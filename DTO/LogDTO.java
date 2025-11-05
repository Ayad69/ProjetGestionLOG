package src.DTO;

public class LogDTO {
    private String codePays;
    private String pays;

    public LogDTO(String codePays, String pays) {
        this.codePays = codePays;
        this.pays = pays;
    }
    public String getCodePays() {
        return codePays;
    }
    public void setCodePays(String codePays) {
        this.codePays = codePays;
    }
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Code du pays : "+ codePays+" Pays : "+ pays;
    }
}
