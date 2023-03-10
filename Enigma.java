public class Enigma{
//memeber virables at the top 

 private Rotor outerRotor;
 private Rotor middleRotor;
 private Rotor innerRotor;


    //write out constructors
    //make an array to hold the values and check which rotor is getting 
    String[] possible_rotors;

    //constructor class
    public Enigma(int id1, int id2, int id3, String letters){
        this.possible_rotors = new String[]{"#GNUAHOVBIPWCJQXDKRYELSZFMT", "#EJOTYCHMRWAFKPUZDINSXBGLQV", "#BDFHJLNPRTVXZACEGIKMOQSUWY", "#NWDKHGXZVRIFJBLMAOPSCYUTQE", "#TGOWHLIFMCSZYRVXQABUPEJKND"};

        this.innerRotor  = new Rotor(possible_rotors[id1-1],letters.charAt(0));
        this.middleRotor = new Rotor(possible_rotors[id2-1],letters.charAt(1));
        this.outerRotor = new Rotor(possible_rotors[id3-1],letters.charAt(2));

    }

    public String encrypt(String message){
        //every time that we encrypt a letter -> move the rotor (call the rotor construcor??)
        //keep track of how many times we rotate
        int count = 0;
        String s1 = "";

        for(int i=0; i < message.length(); i++){

            //enigma algorithem
            char c = message.charAt(i);
            int curletter = this.innerRotor.getIndex(c);
            char nextlet = this.outerRotor.atIndex(curletter);
            int newIndex = this.middleRotor.getIndex(nextlet);
            char lastlet = this.outerRotor.atIndex(newIndex);

            String lastletter = Character.toString(lastlet);
            
            s1 = s1 + lastletter;

            if(count==26){
                middleRotor.Rotate();
                innerRotor.Rotate();
                count=0;

            }else{
                innerRotor.Rotate();
                count++;
            }
            
        }
        return s1;
    }

    public String decrypt(String message){
        //reverse encrypt by i guess doing inverse of encrypt
        int count = 0;
        String decryption = "";

        for(int i=0; i < message.length(); i++){

            //enigma algorithem
            char c = message.charAt(i);
            int curletter = this.outerRotor.getIndex(c);
            char nextlet = this.middleRotor.atIndex(curletter);
            int newIndex = this.outerRotor.getIndex(nextlet);
            char lastlet = this.innerRotor.atIndex(newIndex);

            String lastletter = Character.toString(lastlet);
            
            decryption = decryption + lastletter;

            if(count==26){
                middleRotor.Rotate();
                innerRotor.Rotate();
                count=0;

            }else{
                innerRotor.Rotate();
                count++;
            }
            
        }
        return decryption;
    }

}
