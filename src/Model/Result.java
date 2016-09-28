/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author SentiWord
 */
public class Result {
    
    private  String sentimet;
    private double score = 0;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getSentimet() {
        return sentimet;
    }

    public void setSentimet(String sentimet) {
        this.sentimet = sentimet;
    }

    public Result() {
    }

    public Result(String sentimet, double score) {
        this.sentimet = sentimet;
        this.score = score;
    }
       
}
