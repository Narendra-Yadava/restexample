/***************************************************************************
 *  Copyright (C) Proximus 2019
 *
 *  The reproduction, transmission or use of this document  or its contents
 *  is not  permitted without  prior express written consent of Proximus.
 *  Offenders will be liable for damages. All rights, including  but not 
 *  limited to rights created by patent grant or registration of a utility
 *  model or design, are reserved.
 *
 *  Proximus reserves the right to modify technical specifications and features.
 *
 *  Technical specifications and features are binding only in so far as they
 *  are specifically and expressly agreed upon in a written contract.
 *
 **************************************************************************/
package com.nk.restexample.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

	private static String sqlQuery = "Select ID, NAME, STATUS, POTENTIALSUBSCRIBERCOUNT, LOGO, ADDRESS1, ADDRESS2, ADDRESS3, CITY, STATECODE, ZIP, COUNTRYID, PHONENUMBER, DEFAULTDATEFORMAT, PASSWORDLENGTH, PASSWORDEXPIRATIONDAYS, SURFINGTHRESHOLDSECONDS, CONTENTEXPIRATIONDAYS, RECORDSTATUSCODE, LASTUPDATEDATETIME, LASTUPDATEUSERID, DATETIMESTAMP, PPVADMTSTARTTIME, PPVLASTMOVIECUTOFFMINUTES, FULLIPGSIZE, GLOBALRENTALLIMITAMOUNT, GLOBALRENTALLIMITQUANTITY, FILEPOLLINGPERIODMINUTES, POLLINGPERIODRANDOMMINUTES, REMOTEUPDATEPOLLSTARTTIME, REMOTEUPDATEPOLLENDTIME, ACCOUNTHISTORYDAYS, DEFAULTHOMEPAGEURL, BROKERDELAYSECONDS, BROKERPOLLINGSECONDS, NOTIFIERIPADDRESS, NOTIFIERPORTNUMBER, DEFAULTPHONEFORMAT, PPVPREORDERMINUTES, FREERENTALCREDITLIMIT, CURRENCYCODE, DEFAULTUILANGUAGETYPE, DEFAULTAUDIOLANGUAGETYPE, DEFAULTKEYBOARDCODE, STBASSIGNMENTLIMIT, CHANGELOGLIMIT, ENABLEVODPACKAGING, NPVRKEEPDAYS, NPVRPRERECORDMINUTES, NPVRPOSTRECORDMINUTES, DISPLAYALLCATEGORIES, EASLOGLIMIT, OLDEPGDAYS,OLDEPGDAYSABR, CLIENT_AUTHENTICATION, CLIENT_TIMEOUT, ALTERNATEPVRFALLBACKOPTION, SSREFRESH,SSEXPIRATION, STBAUTOREGISTERINV, SUBSCONFLICTRESOLUTIONTIMEOUT, DISPLAY_HD_CONTENTS, DEFAULTBANDWIDTH, ACTPINTRYMAX, FORCEPINCHANGEDEFAULT, ENABLEBANNERAD, CONNECTIONMODE, VODINTERACTIVITYURL, RULERUNTIME, BILLINGTACURL, IPGCHUNKSIZE, SMALLIPGSIZE, STBIPGWATERMARK, enableStartStopMarks,legacyipgsize,BILLINGSERVERPRESENT, MdSqueryHEPG,enableqoercc,enableqoeret,useglobalbandwidth,allowrccoversubscription,massnotificationrate,fastbootchannelthreshold, LTCNPVRINDEFINITERETENTION, LtcNpvrFiniteRetentionTS, GENERICINTERACTIVITYURL,IMLMAXIMUMDELAY,IMLMINIMUMDELAY, MATVALIDITY, MATMAXREUSE, CUTVWINDOW, PASTCHUNK, MAXIMUMMEMBERLIMIT, VodInteractivityHtmlUrl, GenericInteractivityHtmlUrl, OTTKEYVALIDITYPERIOD, CPDSESSIONTIMEOUT, OTTMINLIFESPANDAYS, OTTLIFESPANEXCEPTIONS, "
			+ "SCHEDULEPATCHTHRESHOLD, ONPVRKEEPDAYS, TECHNICALCUTVWINDOW, NPVRQUOTAWARNING, NPVRSTRICTQUOTA, NPVRQUOTAALERT, NPVRQUOTAALERTDAYS, NPVRQUOTAALERTBUFFER, LTCNPVRKEEPMONTHS, LTCNPVRSTRICTQUOTA, LTCNPVRQUOTAWARNING, LTCNPVRQUOTAALERT ,LTCNPVRQUOTAALERTDAYS, LTCNPVRQUOTAALERTBUFFER,NPVRFORBIDURL,NPVRLTCFORBIDURL,RECSENDMEDIATORFUTUREMINS,RECSENDMEDCHECKINTERVALSEC,MAXRECDELETEPERMIN,NPVRKEEPDELETEDHOURS,NPVRKEEPHISTORYDAYS,EXTCUTVWINDOW from companydetails";

	// private static String sqlQuery = "SELECT * FROM TBL_STB";

	@Autowired
	private Environment env;

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

	public String getDBConf() {
		String dbUserName = env.getProperty("OPENSHIFT_EXT_ORACLE_USERNAME", "Not Found");
		String dbPassword = env.getProperty("OPENSHIFT_EXT_ORACLE_DB_PASSWORD", "Not Found");
		String dbURL = env.getProperty("OPENSHIFT_EXT_ORACLE_DB_URL", "Not Found");

		String dbUserName1 = System.getProperty("OPENSHIFT_EXT_ORACLE_USERNAME", "Not Found");
		String dbPassword1 = System.getProperty("OPENSHIFT_EXT_ORACLE_DB_PASSWORD", "Not Found");
		String dbURL1 = System.getProperty("OPENSHIFT_EXT_ORACLE_DB_URL", "Not Found");
		String str = "OPENSHIFT_EXT_ORACLE_USERNAME : " + dbUserName + " , OPENSHIFT_EXT_ORACLE_DB_PASSWORD : "
				+ dbPassword + " , OPENSHIFT_EXT_ORACLE_DB_URL : " + dbURL +

				" , OPENSHIFT_EXT_ORACLE_USERNAME1 : " + dbUserName1 + " , OPENSHIFT_EXT_ORACLE_DB_PASSWORD1 : "
				+ dbPassword1 + " , OPENSHIFT_EXT_ORACLE_DB_URL1 : " + dbURL1;
		return str;

	}

}
