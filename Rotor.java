public class Rotor{

//write the constructors for this class 
    private String currentRotor;
    private char letter;

    //constrcutor class
    public Rotor(String currentRotor, char curletter){
        this.currentRotor = currentRotor;
        
        String start = Character.toString(curletter);

        while(!this.currentRotor.substring(0,1).equals(start)){

            this.Rotate();
        }

    }
    //return the index
    public int getIndex(char let){
        return this.currentRotor.indexOf(let);

    }
    //return char at index
    public char atIndex(int let){
        return this.currentRotor.charAt(let) ; 
    }

    //rotate the passed in roter
    public void Rotate(){
    
        //charAt and substring 
         String curS = this.currentRotor.substring(0, this.currentRotor.length()-1);
        //make a string of the substring of the and save that 
        this.currentRotor = this.currentRotor.charAt(this.currentRotor.length()-1) + curS;  
    }

}
