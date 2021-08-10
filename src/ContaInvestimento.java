public class ContaInvestimento extends Conta {

    private String tipoInvestimento;
    private float taxaJuros;
    Correntista correntista;

    public ContaInvestimento(int numeroDaConta, Correntista correntista, String tipoInvestimento, float taxaJuros) {
        super(numeroDaConta, correntista);
        if (correntista.getContaCorrente() == null){
            throw new RuntimeException("Correntista sem conta corrente!");
        }
        this.tipoInvestimento = tipoInvestimento;
        this.taxaJuros = taxaJuros;
        this.correntista = correntista;
    }

    public void aplicarJuros() {
        float juros = getSaldoEmReais() * (taxaJuros/100);
        receberDepositoEmDinheiro(juros);
    }
    public void resgatarTotal() {
        float saldoTotal = getSaldoEmReais();
        efetuarTransferecia(correntista.getContaCorrente(), saldoTotal);
    }


}
