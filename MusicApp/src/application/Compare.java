/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Compare {
    Compare(){}
    
    public static String doCompare(String patA, String patB){
        
        // Find the smallest duration
        int smalleastDuration = Parser.findSmallestDuration(patA.toString() + patB.toString());
        //System.out.println(smalleastDuration);
        
        List<Integer> patAInt = Parser.parse(patA, smalleastDuration);
        List<Integer> patBInt = Parser.parse(patB, smalleastDuration);
        List<Integer> comparison = new ArrayList<Integer>();
        
        for (int i = 0; i < Math.min(patAInt.size(), patBInt.size()); i++){
            comparison.add((Math.abs(patAInt.get(i) - patBInt.get(i)))%16);
        }
        //System.out.println("My Comparison String" + comparison);
        
        String[] patAclean = patA.split(" ");
        patAclean = Arrays.copyOfRange(patAclean, 1, patAclean.length);
        
        String[] patBclean = patB.split(" ");
        patBclean = Arrays.copyOfRange(patBclean, 1, patBclean.length);
        
        // Create text files for each pair
        String title = patA.split(" ")[0] + " vs " + patB.split(" ")[0];
        try{
            PrintWriter writer = new PrintWriter( title + ".txt", "UTF-8");
            writer.println(title);
            writer.println(Parser.convertPatternToMidiStr(Arrays.toString(patAclean)));
            writer.println(Parser.convertPatternToMidiStr((Arrays.toString(patBclean)).replaceAll("T120,", "").replaceFirst(",", "").replace("  ", "")));
            writer.println(comparison);
            writer.close();
        } catch (IOException e) {
           // do something
        }
        
        return "Done Writing";
    }
}
