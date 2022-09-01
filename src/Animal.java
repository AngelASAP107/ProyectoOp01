public class Animal {

    String Nombre,TipoAlimentacion,Especie;
    boolean BipedoONo;

    public Animal (String Especie_,String Nombre_, String TipoAlimentacion_,boolean BipedoONo_){

        this.Especie = Especie_;
        this.Nombre = Nombre_;
        this.TipoAlimentacion = TipoAlimentacion_;
        this.BipedoONo = BipedoONo_;
    }

    public void setEspecie(String especie){Especie = especie;}
    public void setNombre(String nombre){Nombre = nombre;}
    public void setTipoAlimentacion(String tipoalimentacion){TipoAlimentacion = tipoalimentacion;}
    public void setBipedoONo(boolean bipedoOno){BipedoONo = bipedoOno;}

    public String getEspecie(){return Especie;}
    public String getNombre(){return Nombre;}
    public String getTipoAlimentacion(){return TipoAlimentacion;}
    public boolean getBipedoONo(){return BipedoONo;}
}
