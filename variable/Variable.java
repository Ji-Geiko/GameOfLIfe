package variable;
import java.util.ArrayList;

import org.omg.PortableServer.LifespanPolicyValue;

import cellule.*;

public class Variable{
    public int[] Position;
    public String state;
    public int lifeCycle;
    public int xLimite;
    public static int yLimite;

    public Variable(){
    }

    //get Variable
        public int[] getPosition(){
            return Position;
        }

        public String getState() {
            return state;
        }

        public int getXLimite() {
            return xLimite;
        }

        public int getYLimite() {
            return yLimite;
        }

        public int getLifeCycle() {
            return lifeCycle;
        }
}