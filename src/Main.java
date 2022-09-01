import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

   public ArrayList<Animal> Animales = new ArrayList<>();
   String[] Especies = {
           "Mamíferos","Aves","Reptiles","Peces","Invertebrados"
   };

   private void CrearAnimal(){
       String NombreA, TipoAlim, TEspecies;
       int BipONo, EspecieOp;
       boolean BipedoNo;

       EspecieOp = JOptionPane.showOptionDialog(null,"Seleccione el tipo de especie",
               "Especies",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,Especies,
               Especies[0]);
       NombreA = JOptionPane.showInputDialog(null,"Ingrese el nombre del animal.",
               "Nombre",JOptionPane.QUESTION_MESSAGE);
       TipoAlim = JOptionPane.showInputDialog(null,"Ingrese el tipo de alimentación.",
               "Tipo de alimentacion",JOptionPane.QUESTION_MESSAGE);
       BipONo = JOptionPane.showConfirmDialog(null,"¿Es bipedo o no?",
               "Bipedo",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

       if (BipONo == 0){
           BipedoNo = true;
       }
       else {
           BipedoNo = false;
       }

       TEspecies = Especies[EspecieOp];

       Animal animal1 = new Animal(TEspecies,NombreA,TipoAlim,BipedoNo);

       Animales.add(animal1);
   }
   private void Menu(){
       int opciones;
       try {
           do {
               String op = JOptionPane.showInputDialog(null, "1.- Crear animal\n" +
                               "2.- Mostrar animales\n" +
                               "0.- Cerrar\n",
                       "Menu", JOptionPane.INFORMATION_MESSAGE);
               opciones = Integer.parseInt(op);
               switch (opciones) {
                   case 1:
                       CrearAnimal();
                       break;
                   case 2:
                       MostrarAnimales();
                       break;
                   case 0:
                       break;
               }
           } while(opciones != 0);
       } catch (Exception e){
           JOptionPane.showMessageDialog(null,"Error, el dato que ingreso es incorrecto.",
                   "ERROR",JOptionPane.ERROR_MESSAGE);
           Menu();
       }

   }
   private void MostrarAnimales(){
       int EspecieOp, cantidad = 0;
       EspecieOp = JOptionPane.showOptionDialog(null,"Seleccione el tipo de especie",
               "Especies",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,Especies,
               Especies[0]);
       for (int i = 0; i < Animales.size(); i++){
           if (Animales.get(i).getEspecie() == Especies[EspecieOp]){
               cantidad++;
           }
       }
       JOptionPane.showMessageDialog(null,"La cantidad de " + Especies[EspecieOp] +
                       " es: " + cantidad, "Cantidad de animales",JOptionPane.ERROR_MESSAGE);

       for (int i = 0; i < Animales.size(); i++){
           if (Animales.get(i).getEspecie() == Especies[EspecieOp]){
               String respuesta;
               if(Animales.get(i).getBipedoONo() == true){
                   respuesta = "Si.";
               }else{
                   respuesta = "No.";
               }
               JOptionPane.showMessageDialog(null,"Nombre: " + Animales.get(i).getNombre()
                       + "\nTipo de alimentacion: " + Animales.get(i).getTipoAlimentacion()
                       + "\n¿Es bipedo? " + respuesta,
                       "Informacion del animal",JOptionPane.INFORMATION_MESSAGE);
           }
       }
   }

    public static void main(String[] args) {
       Main m = new Main();
        m.Menu();
    }
}