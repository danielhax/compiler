/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emcy0
 */
public class Analyzer {
    
    public Analyzer(){
        
    }
    
    InputStream fis;
    InputStreamReader isr;
    BufferedReader br;
    
    private final ArrayList<String> DATA_TYPES = new ArrayList<String>(Arrays.asList("boolean", "byte", "char", "short", "int", "long", "float", "double", "void"));
    private final ArrayList<String> ACCESS_MODIFIERS = new ArrayList<String>(Arrays.asList("private", "public", "protected"));
    private final ArrayList<String> ACCESS_TYPES = new ArrayList<String>(Arrays.asList("static", "final"));
    
    public String analyzeToken(String token){
        String line = "";
        if(isDataType(token)){
            line += token + " = Data Type";
        } else if (isAccessModifier(token) || isAccessType(token)){
            line += token + " = Access Modifier";
        } else {
            line += token + " = N/A";
        }
        return line + "\n";
    }
    
    private boolean isDataType(String token){
        
        if(DATA_TYPES.contains(token)){
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isAccessModifier(String token){
        
        if(ACCESS_MODIFIERS.contains(token)){
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isAccessType(String token){
        
        if(ACCESS_TYPES.contains(token)){
            return true;
        } else {
            return false;
        }
    }
}
