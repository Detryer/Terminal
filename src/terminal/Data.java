package terminal;

public class Data {

    private String SD;
    private Long divId;
    private Long claimId;
    private Integer tradeId;
    private Integer acct;
    private Integer amount;
    private Integer recAcct;
    private Integer entAcct;
    private String inputFolder;
    private String outputFolder;
    private String defaultInputFolder;
    private String defaultOutputFolder;

    public String getSD() {
        return SD;
    }

    public void setSD(String SD) {
        this.SD = SD;
    }

    public Long getDivId() {
        return divId;
    }

    public void setDivId(Long divId) {
        this.divId = divId;
    }

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    public Integer getAcct() {
        return acct;
    }

    public void setAcct(Integer acct) {
        this.acct = acct;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getRecAcct() {
        return recAcct;
    }

    public void setRecAcct(Integer recAcct) {
        this.recAcct = recAcct;
    }

    public Integer getEntAcct() {
        return entAcct;
    }

    public void setEntAcct(Integer entAcct) {
        this.entAcct = entAcct;
    }

    public String getInputFolder() {
        return inputFolder;
    }

    public void setInputFolder(String inputFolder) {
        this.inputFolder = inputFolder;
    }

    public String getOutputFolder() {
        return outputFolder;
    }

    public void setOutputFolder(String outputFolder) {
        this.outputFolder = outputFolder;
    }

    public String getDefaultInputFolder() {
        return defaultInputFolder;
    }

    public void setDefaultInputFolder(String defaultInputFolder){
        this.defaultInputFolder = defaultInputFolder;
    }

    public String getDefaultOutputFolder() {
        return defaultInputFolder;
    }

    public void setDefaultOutputFolder(String defaultOutputFolder) {
        this.defaultOutputFolder = defaultOutputFolder;
    }
}