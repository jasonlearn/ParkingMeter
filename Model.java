
/**
 * Write a description of class Model here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Model
{
    public double pay(){
        double pay = 0.0;
        double bonus = 0.0;
        if(tall && thin){
            bonus = 2;
            if(getTravel() == true){
                bonus += 1;
                if(getSmokes() == true){
                    bonus -= 1;
                }
            }
            pay = pay + bonus;
        }
        else{
            if(getTravel() == true){
                bonus += 1;
                if(getSmokes() == true){
                    bonus -= 1;
                }
            }
            pay += bonus;
        }
        return pay;
    }

    public double pay(){
        double bonus == 0.0;
        if(smokes()){
            bonus -= 10;
        }else if(travel()){
            bonus += 4;
        }else if(tall && skinny){
            bonus += 5;
        }
        return basepay + bonus;
    }
}
