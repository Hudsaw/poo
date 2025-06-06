package simulador;

import java.time.LocalDateTime;

public class RegistroGlicemia {
    private LocalDateTime data;
    private String tipo;
    private Integer quantidade;
    private Integer glicemiaAntes;
    private Integer glicemiaDepois;
    private String indicacao;

    public RegistroGlicemia(LocalDateTime data, String tipo, Integer quantidade,
                            Integer glicemiaAntes, Integer glicemiaDepois, String indicacao) {
        this.data = data;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.glicemiaAntes = glicemiaAntes;
        this.glicemiaDepois = glicemiaDepois;
        this.indicacao = indicacao;
    }

    public LocalDateTime getData() { return data; }
    public String getTipo() { return tipo; }
    public Integer getQuantidade() { return quantidade; }
    public Integer getGlicemiaAntes() { return glicemiaAntes; }
    public Integer getGlicemiaDepois() { return glicemiaDepois; }
    public String getIndicacao() { return indicacao; }
}