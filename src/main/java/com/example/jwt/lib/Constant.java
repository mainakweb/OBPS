package com.example.jwt.lib;

import org.springframework.stereotype.Service;

@Service
public class Constant {
    public static final String INSERT = "INSERT";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";
    public static final String ARCHIVE = "ARCHIVE";
    public static final String NEW = "NEW";
    public static final String SENT = "SENT";
    public static final boolean TRUE = true;
    public static final boolean FALSE = false;
    public static final String YES = "YES";
    public static final int USER_TYPE_VENDOR = 1;
    public static final int USER_TYPE_GRSE_DRAWING = 2;
    public static final int USER_TYPE_GRSE_QAP = 3;
    public static final int USER_TYPE_GRSE_FINANCE = 15;
    public static final int USER_TYPE_GRSE_PURCHASE = 17;
    public static final int USER_TYPE_GRSE_HR = 18;
    public static final int USER_TYPE_ADMIN = 5;
    public static final int USER_TYPE_SUPER_ADMIN = 6;
    public static final int USER_TYPE_PPNC_DEPARTMENT = 14;
    public static final int ASSIGNER = 1;
    public static final int STAFF = 2;
    public static final String PROJECT = "project";
    public static final String WBS_ELEMENT = "wbs_element";
    public static final String C_SDBG_DATE = "CONTRACTUAL SDBG/IB SUBMISSION DATE";
    public static final String C_DRAWING_DATE = "CONTRACTUAL DRAWING SUBMISSION DATE";
    public static final String C_QAP_DATE = "CONTRACTUAL QAP SUBMISSION DATE";
    public static final String C_ILMS_DATE = "CONTRACTUAL ILMS SUBMISSION DATE";
    public static final String A_SDBG_DATE = "ACTUAL SDBG SUBMISSION DATE";
    public static final String A_DRAWING_DATE = "ACTUAL DRAWING SUBMISSION DATE";
    public static final String A_QAP_DATE = "ACTUAL QAP SUBMISSION DATE";
    public static final String A_ILMS_DATE = "ACTUAL ILMS SUBMISSION DATE";
    public static final String ACTION_SDBG = "SDBG SUBMISSION";
    public static final String ACTION_PBG = "PBG SUBMISSION";
    public static final String ACTION_IB = "INDEMNITY BOND SUBMISSION";
    public static final String ACTION_DD = "DEMAND DRAFT SUBMISSION";
    public static final String SERVICE_TYPE = "service";
    public static final String MATERIAL_TYPE = "material";
    public static final String CSV_DATA_PATH = "sync/csvData";
    public static final String ZIP_DATA_PATH = "sync/zipData";
    public static final String UNZIP_DATA_PATH = "sync/unzipData";
    public static final String OTHER_SERVER_DATA_PATH = "sync/otherServerData/Data";
    public static final String UNSYNCED_FILES = "sync/unsyncedFiles";
    public static final String OTHER_SERVER_FILE_PATH = "sync/otherServerData/Files";
    public static final String MAIL_SEND_MAX_RETRY_COUNT = "3";
    public static final String MAIL_SEND_DEFAULT_RETRY_COUNT = "0";
    public static final String LAN_SERVER_PO_PATH = "/var/www/html/obps/backend_obps/uploads/po";
    public static final String LAN_SERVER_PAYMENT_ADVICE_PATH =
            "/var/www/html/obps/backend_obps/uploads/paymentadvice";
    public static final String MID_SDBG = "01";
    public static final String MID_DRAWING = "02";
    public static final String MID_QAP = "03";
    public static final String MID_ILMS = "04";
    public static final String BTN_STATUS_HOLD_CODE = "X";
    public static final String BTN_STATUS_PROCESS_ID = "037";

}
