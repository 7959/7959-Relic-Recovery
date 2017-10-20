package org.firstinspires.ftc.teamcode.Opmodes;

/**
 * Created by Robi on 10/18/2017.
 */

public class TwoDemVector {

    /**
     * A Basic Two dimensional vector object
     */
    float x;
    float y;
    public float angle(){
        return (float) Math.atan2(y, x);
    }
    public float mag(){
        return (float) Math.sqrt(x*x+y*y);
    }
    public TwoDemVector(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void sub(TwoDemVector vect){
        this.x -= vect.x;
        this.y -= vect.y;
    }
    public void add(TwoDemVector vect){
        this.x += vect.x;
        this.y += vect.y;
    }
    public void scale(float scalar){
        this.x = scalar * x;
        this.y = scalar * y;
    }
    public float dot(TwoDemVector vect){
        return (float) (this.mag() * vect.mag() * Math.cos(this.angle() - vect.angle()));
    }

}
