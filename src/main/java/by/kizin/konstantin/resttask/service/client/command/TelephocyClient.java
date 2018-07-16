package by.kizin.konstantin.resttask.service.client.command;

import java.util.Date;

public interface TelephocyClient {

    TelephocyHistory getHistoryByUuid(final String UUID, final TelepthonyOptions options) throws Exception;

    TelephonyRecord getRecordByUuid(final String UUI, final TelepthonyOptions options) throws Exception;

    TelephocyHistory getHistoryByStartAndFinishDates(final Date start, final Date end,final TelepthonyOptions options) throws Exception;

}
