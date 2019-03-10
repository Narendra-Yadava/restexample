package com.nk.restexample.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * CompanyDAO.java
 *
 * @author Narendra.Kumar
 *
 * @date Mar 10, 2019
 *
 */
@Repository
public class CompanyDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/*private static String sqlQuery = "Select ID, NAME, STATUS, POTENTIALSUBSCRIBERCOUNT, LOGO, ADDRESS1, ADDRESS2, ADDRESS3, CITY, STATECODE, ZIP, COUNTRYID, PHONENUMBER, DEFAULTDATEFORMAT, PASSWORDLENGTH, PASSWORDEXPIRATIONDAYS, SURFINGTHRESHOLDSECONDS, CONTENTEXPIRATIONDAYS, RECORDSTATUSCODE, LASTUPDATEDATETIME, LASTUPDATEUSERID, DATETIMESTAMP, PPVADMTSTARTTIME, PPVLASTMOVIECUTOFFMINUTES, FULLIPGSIZE, GLOBALRENTALLIMITAMOUNT, GLOBALRENTALLIMITQUANTITY, FILEPOLLINGPERIODMINUTES, POLLINGPERIODRANDOMMINUTES, REMOTEUPDATEPOLLSTARTTIME, REMOTEUPDATEPOLLENDTIME, ACCOUNTHISTORYDAYS, DEFAULTHOMEPAGEURL, BROKERDELAYSECONDS, BROKERPOLLINGSECONDS, NOTIFIERIPADDRESS, NOTIFIERPORTNUMBER, DEFAULTPHONEFORMAT, PPVPREORDERMINUTES, FREERENTALCREDITLIMIT, CURRENCYCODE, DEFAULTUILANGUAGETYPE, DEFAULTAUDIOLANGUAGETYPE, DEFAULTKEYBOARDCODE, STBASSIGNMENTLIMIT, CHANGELOGLIMIT, ENABLEVODPACKAGING, NPVRKEEPDAYS, NPVRPRERECORDMINUTES, NPVRPOSTRECORDMINUTES, DISPLAYALLCATEGORIES, EASLOGLIMIT, OLDEPGDAYS,OLDEPGDAYSABR, CLIENT_AUTHENTICATION, CLIENT_TIMEOUT, ALTERNATEPVRFALLBACKOPTION, SSREFRESH,SSEXPIRATION, STBAUTOREGISTERINV, SUBSCONFLICTRESOLUTIONTIMEOUT, DISPLAY_HD_CONTENTS, DEFAULTBANDWIDTH, ACTPINTRYMAX, FORCEPINCHANGEDEFAULT, ENABLEBANNERAD, CONNECTIONMODE, VODINTERACTIVITYURL, RULERUNTIME, BILLINGTACURL, IPGCHUNKSIZE, SMALLIPGSIZE, STBIPGWATERMARK, enableStartStopMarks,legacyipgsize,BILLINGSERVERPRESENT, MdSqueryHEPG,enableqoercc,enableqoeret,useglobalbandwidth,allowrccoversubscription,massnotificationrate,fastbootchannelthreshold, LTCNPVRINDEFINITERETENTION, LtcNpvrFiniteRetentionTS, GENERICINTERACTIVITYURL,IMLMAXIMUMDELAY,IMLMINIMUMDELAY, MATVALIDITY, MATMAXREUSE, CUTVWINDOW, PASTCHUNK, MAXIMUMMEMBERLIMIT, VodInteractivityHtmlUrl, GenericInteractivityHtmlUrl, OTTKEYVALIDITYPERIOD, CPDSESSIONTIMEOUT, OTTMINLIFESPANDAYS, OTTLIFESPANEXCEPTIONS, "
			+ "SCHEDULEPATCHTHRESHOLD, ONPVRKEEPDAYS, TECHNICALCUTVWINDOW, NPVRQUOTAWARNING, NPVRSTRICTQUOTA, NPVRQUOTAALERT, NPVRQUOTAALERTDAYS, NPVRQUOTAALERTBUFFER, LTCNPVRKEEPMONTHS, LTCNPVRSTRICTQUOTA, LTCNPVRQUOTAWARNING, LTCNPVRQUOTAALERT ,LTCNPVRQUOTAALERTDAYS, LTCNPVRQUOTAALERTBUFFER,NPVRFORBIDURL,NPVRLTCFORBIDURL,RECSENDMEDIATORFUTUREMINS,RECSENDMEDCHECKINTERVALSEC,MAXRECDELETEPERMIN,NPVRKEEPDELETEDHOURS,NPVRKEEPHISTORYDAYS,EXTCUTVWINDOW from companydetails";*/
	
	private static String sqlQuery = "SELECT * FROM TBL_STB";



	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> getCompanyProperties() {
		List<Map<String, Object>> list = null;
		logger.info("getCompanyProperties++");
		try {
			logger.info("list++");

			list = jdbcTemplate.queryForList(sqlQuery);
			logger.info("list size :" + list.size());

		} catch (DataAccessException dae) {
			logger.error("getCompanyProperties error message : " + dae.getMessage());
		}
		logger.info("getCompanyProperties++");
		return list;

	}

}