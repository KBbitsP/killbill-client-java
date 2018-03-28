/*
 * Copyright 2014-2018 Groupon, Inc
 * Copyright 2014-2018 The Billing Project, LLC
 *
 * The Billing Project licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */


package org.killbill.billing.client.api.gen;


import org.killbill.billing.client.model.gen.CustomField;
import org.killbill.billing.client.model.gen.PaymentMethod;
import java.util.UUID;
import org.killbill.billing.client.model.CustomFields;
import java.util.List;
import java.util.Map;
import org.killbill.billing.util.api.AuditLevel;
import org.killbill.billing.client.model.PaymentMethods;

import com.google.common.collect.Multimap;
import com.google.common.base.Preconditions;
import com.google.common.base.MoreObjects;
import com.google.common.collect.LinkedListMultimap;

import org.killbill.billing.client.Converter;
import org.killbill.billing.client.KillBillClientException;
import org.killbill.billing.client.KillBillHttpClient;
import org.killbill.billing.client.RequestOptions;
import org.killbill.billing.client.RequestOptions.RequestOptionsBuilder;


/**
 *           DO NOT EDIT !!!
 *
 * This code has been generated by the Kill Bill swagger generator.
 *  @See https://github.com/killbill/killbill-swagger-coden
 */
public class PaymentMethodApi {

    private final KillBillHttpClient httpClient;

    public PaymentMethodApi() {
        this(new KillBillHttpClient());
    }

    public PaymentMethodApi(final KillBillHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public CustomFields createCustomFields(final UUID paymentMethodId, final CustomFields body, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(paymentMethodId, "Missing the required parameter 'paymentMethodId' when calling createCustomFields");
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling createCustomFields");

        final String uri = "/1.0/kb/paymentMethods/{paymentMethodId}/customFields"
          .replaceAll("\\{" + "paymentMethodId" + "\\}", paymentMethodId.toString());


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        final Boolean followLocation = MoreObjects.firstNonNull(inputOptions.getFollowLocation(), Boolean.TRUE);
        inputOptionsBuilder.withFollowLocation(followLocation);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doPost(uri, body, CustomFields.class, requestOptions);
    }


    public void deleteCustomFields(final UUID paymentMethodId, final List<UUID> customField, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(paymentMethodId, "Missing the required parameter 'paymentMethodId' when calling deleteCustomFields");

        final String uri = "/1.0/kb/paymentMethods/{paymentMethodId}/customFields"
          .replaceAll("\\{" + "paymentMethodId" + "\\}", paymentMethodId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (customField != null) {
            queryParams.putAll("customField", Converter.convertUUIDListToStringList(customField));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doDelete(uri, requestOptions);
    }

    public void deletePaymentMethod(final UUID paymentMethodId, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        deletePaymentMethod(paymentMethodId, Boolean.valueOf(false), Boolean.valueOf(false), pluginProperty, inputOptions);
    }


    public void deletePaymentMethod(final UUID paymentMethodId, final Boolean deleteDefaultPmWithAutoPayOff, final Boolean forceDefaultPmDeletion, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(paymentMethodId, "Missing the required parameter 'paymentMethodId' when calling deletePaymentMethod");

        final String uri = "/1.0/kb/paymentMethods/{paymentMethodId}"
          .replaceAll("\\{" + "paymentMethodId" + "\\}", paymentMethodId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (deleteDefaultPmWithAutoPayOff != null) {
            queryParams.put("deleteDefaultPmWithAutoPayOff", String.valueOf(deleteDefaultPmWithAutoPayOff));
        }
        if (forceDefaultPmDeletion != null) {
            queryParams.put("forceDefaultPmDeletion", String.valueOf(forceDefaultPmDeletion));
        }
        if (pluginProperty != null) {
            queryParams.putAll("pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doDelete(uri, requestOptions);
    }

    public CustomFields getCustomFields(final UUID paymentMethodId, final RequestOptions inputOptions) throws KillBillClientException {
        return getCustomFields(paymentMethodId, AuditLevel.NONE, inputOptions);
    }

    public CustomFields getCustomFields(final UUID paymentMethodId, final AuditLevel audit, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(paymentMethodId, "Missing the required parameter 'paymentMethodId' when calling getCustomFields");

        final String uri = "/1.0/kb/paymentMethods/{paymentMethodId}/customFields"
          .replaceAll("\\{" + "paymentMethodId" + "\\}", paymentMethodId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (audit != null) {
            queryParams.put("audit", String.valueOf(audit));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, CustomFields.class, requestOptions);
    }

    public PaymentMethod getPaymentMethod(final UUID paymentMethodId, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        return getPaymentMethod(paymentMethodId, Boolean.valueOf(false), Boolean.valueOf(false), pluginProperty, AuditLevel.NONE, inputOptions);
    }

    public PaymentMethod getPaymentMethod(final UUID paymentMethodId, final Boolean includedDeleted, final Boolean withPluginInfo, final Map<String, String> pluginProperty, final AuditLevel audit, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(paymentMethodId, "Missing the required parameter 'paymentMethodId' when calling getPaymentMethod");

        final String uri = "/1.0/kb/paymentMethods/{paymentMethodId}"
          .replaceAll("\\{" + "paymentMethodId" + "\\}", paymentMethodId.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (includedDeleted != null) {
            queryParams.put("includedDeleted", String.valueOf(includedDeleted));
        }
        if (withPluginInfo != null) {
            queryParams.put("withPluginInfo", String.valueOf(withPluginInfo));
        }
        if (pluginProperty != null) {
            queryParams.putAll("pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }
        if (audit != null) {
            queryParams.put("audit", String.valueOf(audit));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, PaymentMethod.class, requestOptions);
    }

    public PaymentMethod getPaymentMethodByKey(final String externalKey, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        return getPaymentMethodByKey(externalKey, Boolean.valueOf(false), Boolean.valueOf(false), pluginProperty, AuditLevel.NONE, inputOptions);
    }

    public PaymentMethod getPaymentMethodByKey(final String externalKey, final Boolean includedDeleted, final Boolean withPluginInfo, final Map<String, String> pluginProperty, final AuditLevel audit, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(externalKey, "Missing the required parameter 'externalKey' when calling getPaymentMethodByKey");

        final String uri = "/1.0/kb/paymentMethods";

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (externalKey != null) {
            queryParams.put("externalKey", String.valueOf(externalKey));
        }
        if (includedDeleted != null) {
            queryParams.put("includedDeleted", String.valueOf(includedDeleted));
        }
        if (withPluginInfo != null) {
            queryParams.put("withPluginInfo", String.valueOf(withPluginInfo));
        }
        if (pluginProperty != null) {
            queryParams.putAll("pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }
        if (audit != null) {
            queryParams.put("audit", String.valueOf(audit));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, PaymentMethod.class, requestOptions);
    }

    public PaymentMethods getPaymentMethods(final String pluginName, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        return getPaymentMethods(Long.valueOf(0), Long.valueOf(100), pluginName, Boolean.valueOf(false), pluginProperty, AuditLevel.NONE, inputOptions);
    }

    public PaymentMethods getPaymentMethods(final Long offset, final Long limit, final String pluginName, final Boolean withPluginInfo, final Map<String, String> pluginProperty, final AuditLevel audit, final RequestOptions inputOptions) throws KillBillClientException {

        final String uri = "/1.0/kb/paymentMethods/pagination";

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (offset != null) {
            queryParams.put("offset", String.valueOf(offset));
        }
        if (limit != null) {
            queryParams.put("limit", String.valueOf(limit));
        }
        if (pluginName != null) {
            queryParams.put("pluginName", String.valueOf(pluginName));
        }
        if (withPluginInfo != null) {
            queryParams.put("withPluginInfo", String.valueOf(withPluginInfo));
        }
        if (pluginProperty != null) {
            queryParams.putAll("pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }
        if (audit != null) {
            queryParams.put("audit", String.valueOf(audit));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, PaymentMethods.class, requestOptions);
    }

    public void modifyCustomFields(final UUID paymentMethodId, final CustomFields body, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(paymentMethodId, "Missing the required parameter 'paymentMethodId' when calling modifyCustomFields");
        Preconditions.checkNotNull(body, "Missing the required parameter 'body' when calling modifyCustomFields");

        final String uri = "/1.0/kb/paymentMethods/{paymentMethodId}/customFields"
          .replaceAll("\\{" + "paymentMethodId" + "\\}", paymentMethodId.toString());


        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_CONTENT_TYPE, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        httpClient.doPut(uri, body, requestOptions);
    }

    public PaymentMethods searchPaymentMethods(final String searchKey, final String pluginName, final Map<String, String> pluginProperty, final RequestOptions inputOptions) throws KillBillClientException {
        return searchPaymentMethods(searchKey, Long.valueOf(0), Long.valueOf(100), pluginName, Boolean.valueOf(false), pluginProperty, AuditLevel.NONE, inputOptions);
    }

    public PaymentMethods searchPaymentMethods(final String searchKey, final Long offset, final Long limit, final String pluginName, final Boolean withPluginInfo, final Map<String, String> pluginProperty, final AuditLevel audit, final RequestOptions inputOptions) throws KillBillClientException {
        Preconditions.checkNotNull(searchKey, "Missing the required parameter 'searchKey' when calling searchPaymentMethods");

        final String uri = "/1.0/kb/paymentMethods/search/{searchKey}"
          .replaceAll("\\{" + "searchKey" + "\\}", searchKey.toString());

        final Multimap<String, String> queryParams = LinkedListMultimap.create(inputOptions.getQueryParams());
        if (offset != null) {
            queryParams.put("offset", String.valueOf(offset));
        }
        if (limit != null) {
            queryParams.put("limit", String.valueOf(limit));
        }
        if (pluginName != null) {
            queryParams.put("pluginName", String.valueOf(pluginName));
        }
        if (withPluginInfo != null) {
            queryParams.put("withPluginInfo", String.valueOf(withPluginInfo));
        }
        if (pluginProperty != null) {
            queryParams.putAll("pluginProperty", Converter.convertPluginPropertyMap(pluginProperty));
        }
        if (audit != null) {
            queryParams.put("audit", String.valueOf(audit));
        }

        final RequestOptionsBuilder inputOptionsBuilder = inputOptions.extend();
        inputOptionsBuilder.withQueryParams(queryParams);
        inputOptionsBuilder.withHeader(KillBillHttpClient.HTTP_HEADER_ACCEPT, "application/json");
        final RequestOptions requestOptions = inputOptionsBuilder.build();

        return httpClient.doGet(uri, PaymentMethods.class, requestOptions);
    }

}
