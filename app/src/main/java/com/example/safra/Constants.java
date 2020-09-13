package com.example.safra;

public class Constants {
    public static final String AZURE_BASE_URL = "https://safraapi.azurewebsites.net/api/v1/";
    public static final String SAFRA_BASE_URL = "https://af3tqle6wgdocsdirzlfrq7w5m.apigateway.sa-saopaulo-1.oci.customer-oci.com/fiap-sandbox/";
    public static final String BASE_AUTH_URL = "https://idcs-902a944ff6854c5fbe94750e48d66be5.identity.oraclecloud.com/oauth2/v1/";
    public static final String TOKEN = "token";
    public static final String HTTP_AUTHORIZATION_VALUE_PREFIX = "Bearer %s";


    // Open Banking
    public static final String BASE_OPEN_BANKING_ENDPOINT = "open-banking/v1/accounts";
    public static final String ACCOUNT_INFO_ENDPOINT = BASE_OPEN_BANKING_ENDPOINT + "/{accountId}";
    public static final String BALANCE_INFO_ENDPOINT = BASE_OPEN_BANKING_ENDPOINT + "/{accountId}" + "/balances";
    public static final String TRANSACTION_INFO_ENDPOINT = BASE_OPEN_BANKING_ENDPOINT + "/{accountId}" + "/transactions";

    // Movements
    public static final String BASE_MOVEMENTS_ENDPOINT = "accounts/v1/accounts";
    public static final String TRANSFER_ENDPOINT = BASE_MOVEMENTS_ENDPOINT + "/{accountId}" + "/transfer";

    // Calls
    public static final String BASE_CALL_ENDPOINT = "media/v1/youtube";

    // OPEN ACCOUNT
    public static final String BASE_OPEN_ACCOUNT_ENDPOINT = "accounts/v1/optin";

    // HEALTH
    public static final String HEALTH_SUFFIX = "health";

    // CODES
    public static final String CLIENT_ID = "f9d3cd9600874ac2803d03ca709b78eb";
    public static final String SECRET = "1a2075e3-b15e-4324-902c-0f12f8f08082";

    // PRODUCTS
    public static final String PRODUCTS = "account/{account}/products";
    public static final String SALES = "sale";
}
