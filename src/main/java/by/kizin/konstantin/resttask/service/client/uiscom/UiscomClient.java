package by.kizin.konstantin.resttask.service.client.uiscom;

import by.kizin.konstantin.resttask.service.client.uiscom.entity.AuthResponse;
import by.kizin.konstantin.resttask.service.client.uiscom.entity.UiscomTelephonyOptions;

public interface UiscomClient {

    /**
     * Return authObject with access token and id. Sets the value inside incomming options Access token lives only one hour. If need more,
     * then make configuration  in account.
     * @param options
     */
    void authorization(final UiscomTelephonyOptions options);

    String[] getVirtualNumbersForSipLine(final UiscomTelephonyOptions options);




}
