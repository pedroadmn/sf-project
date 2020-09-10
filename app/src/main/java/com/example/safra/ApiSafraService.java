package com.example.safra;

import com.example.safra.models.accountBalance.AccountBalanceResponse;
import com.example.safra.models.accountInfo.AccountInfoResponse;
import com.example.safra.models.UserRequest;

import java.util.Map;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiSafraService {
    @GET(Constants.HEALTH_SUFFIX)
    Completable getHealth(@HeaderMap Map<String, String> headers);

    @POST(Constants.BASE_OPEN_ACCOUNT_ENDPOINT)
    Completable createAccount(@HeaderMap Map<String, String> headers, @Body UserRequest user);

    @GET(Constants.ACCOUNT_INFO_ENDPOINT)
    Observable<AccountInfoResponse> getAccountInfo(@HeaderMap Map<String, String> headers, @Path("accountId") String accountId);

    @GET(Constants.BALANCE_INFO_ENDPOINT)
    Observable<AccountBalanceResponse> getAccountBalances(@HeaderMap Map<String, String> headers, @Path("accountId") String accountId);

    @GET(Constants.TRANSACTION_INFO_ENDPOINT)
    Observable<AccountBalanceResponse> getAccountTransaction(@HeaderMap Map<String, String> headers, @Path("accountId") String accountId);

    @POST(Constants.TRANSFER_ENDPOINT)
    Observable<AccountBalanceResponse> transfers(@HeaderMap Map<String, String> headers, @Path("accountId") String accountId);
}
