package entita;

import java.util.Arrays;

public class Utente {
    private int ID;
    private String nome;
    private String cognome;
    private String codice_fiscale;
    private String data_di_nascita;
    private float saldo;
    private Patente[] patenti;
    private int[] posizione_utente = new int[3];

    private boolean casco;

    public boolean isCasco() {
        return casco;
    }

    public Utente(String nome, String cognome, String codice_fiscale, String data_di_nascita, float saldo, boolean casco, Patente[] patenti) {
        this.nome = nome;
        this.cognome = cognome;
        this.codice_fiscale = codice_fiscale;
        this.data_di_nascita = data_di_nascita;
        this.saldo = saldo;
        this.patenti = patenti;
        ID = codice_fiscale.hashCode();
        if(ID<0)
            ID*=-1;
        this.casco=casco;
    }

    public int getID() {
        return ID;
    }

    public float getSaldo() {
        return saldo;
    }

    public Patente getPatente(int i) {
        return patenti[i]; //TODO da rivedere
    }

    public int[] getPosizioneUtente() {
        return posizione_utente;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public void updateSaldo(float money,boolean addCredito){
        if(addCredito)
            this.saldo+=money;
        else
            this.saldo-=money;
    }

    public void setPosizioneUtente(int[] posizione_utente) {
        this.posizione_utente = posizione_utente;
    }
    public String writeAsCsv() {
        return String.join(",", Arrays.asList(Integer.toString(ID), nome, cognome,codice_fiscale, data_di_nascita,Float.toString(saldo),Boolean.toString(casco),Arrays.toString(patenti)));
    }



    @Override
    public String toString() {
        StringBuilder driving_licenses = new StringBuilder();

        driving_licenses.append("[ ");

        for (Patente patente : patenti)
            if (patente != null)
                driving_licenses.append(patente+ " ");

        driving_licenses.append("]");

        return "ID: " +ID+ "\nNome: " +nome+ "\nCognome: " +cognome+ "\nCodice fiscale: " +codice_fiscale+ "\nData di nascita: "
                +data_di_nascita+ "\nSaldo: " +saldo+ "€\nPatenti: " +driving_licenses+ "\nCasco: "+casco+"\nPosizione: " +Arrays.toString(posizione_utente)+"\n\n";
    }
}
