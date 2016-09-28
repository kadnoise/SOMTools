package Model;
  
public class Credenciais {

    private String CONSUMER_KEY = "*****************";
    private String CONSUMER_SECRET = "***************";
    private String ACCESS_TOKEN = "1222694389-*****";
    private String ACCESS_TOKEN_SECRET = "*****************";

    public String getACCESS_TOKEN() {
        return ACCESS_TOKEN;
    }

    public void setACCESS_TOKEN(String ACCESS_TOKEN) {
        this.ACCESS_TOKEN = ACCESS_TOKEN;
    }

    public String getACCESS_TOKEN_SECRET() {
        return ACCESS_TOKEN_SECRET;
    }

    public void setACCESS_TOKEN_SECRET(String ACCESS_TOKEN_SECRET) {
        this.ACCESS_TOKEN_SECRET = ACCESS_TOKEN_SECRET;
    }
    
    public String getCONSUMER_KEY() {
        return CONSUMER_KEY;
    }

    public void setCONSUMER_KEY(String CONSUMER_KEY) {
        this.CONSUMER_KEY = CONSUMER_KEY;
    }

    public String getCONSUMER_SECRET() {
        return CONSUMER_SECRET;
    }

    public void setCONSUMER_SECRET(String CONSUMER_SECRET) {
        this.CONSUMER_SECRET = CONSUMER_SECRET;
    }
    
}

