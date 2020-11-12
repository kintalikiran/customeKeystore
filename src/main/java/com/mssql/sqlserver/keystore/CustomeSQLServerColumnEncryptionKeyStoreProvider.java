package com.mssql.sqlserver.keystore;


import com.microsoft.sqlserver.jdbc.SQLServerColumnEncryptionKeyStoreProvider;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class CustomeSQLServerColumnEncryptionKeyStoreProvider extends SQLServerColumnEncryptionKeyStoreProvider{
	
	static final private java.util.logging.Logger customeCertificateStoreLogger = java.util.logging.Logger
            .getLogger("com.mssql.sqlserver.keystore.CustomeSQLServerColumnEncryptionKeyStoreProvider");
	
	// String name = "MSSQL_CERTIFICATE_STORE";
	 
	 String name = "CUSTOM_KEYSTORE";
	 
    /**
     * Constructs a SQLServerColumnEncryptionCertificateStoreProvider.
     */
    public CustomeSQLServerColumnEncryptionKeyStoreProvider(String keyStoreLocation,char[] keyStoreSecret) {
    	customeCertificateStoreLogger.entering(CustomeSQLServerColumnEncryptionKeyStoreProvider.class.getName(),
                "CustomeSQLServerColumnEncryptionKeyStoreProvider");
    }

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	

	public byte[] decryptColumnEncryptionKey(String masterKeyPath, String encryptionAlgorithm,
			byte[] encryptedColumnEncryptionKey) throws SQLServerException {
		customeCertificateStoreLogger.entering(CustomeSQLServerColumnEncryptionKeyStoreProvider.class.getName(),
                "decryptColumnEncryptionKey", "Decrypting Column Encryption Key.");
		
		
		byte[] plainCEK = null;       
		
		customeCertificateStoreLogger.exiting(CustomeSQLServerColumnEncryptionKeyStoreProvider.class.getName(),
                "decryptColumnEncryptionKey", "Finished decrypting Column Encryption Key.");
		return plainCEK;
	}

	@Override
	public byte[] encryptColumnEncryptionKey(String masterKeyPath, String encryptionAlgorithm,
			byte[] plainTextColumnEncryptionKey) throws SQLServerException {
		customeCertificateStoreLogger.entering(CustomeSQLServerColumnEncryptionKeyStoreProvider.class.getName(),
                "EncryptColumnEncryptionKey","Encrypting Column Encryption Key.");

		if (null == masterKeyPath || masterKeyPath.trim().length() == 0) {
	            System.out.println("R_InvalidMasterKeyDetails");
	      }
		
			
		
		 
		
		customeCertificateStoreLogger.exiting(CustomeSQLServerColumnEncryptionKeyStoreProvider.class.getName(),
	                "EncryptColumnEncryptionKey","Encrypting Column Encryption Key.");

		return null;
	}

	@Override
	public boolean verifyColumnMasterKeyMetadata(String masterKeyPath, boolean allowEnclaveComputations,
			byte[] signature) throws SQLServerException {
		// TODO Auto-generated method stub
		return false;
	}

}
