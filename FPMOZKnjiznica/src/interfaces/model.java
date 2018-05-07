/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author itic-4
 * @param <Object>
 */
public interface model <Object> {
    public Object spasi();
    public Object uredi();
    public boolean brisi();
    public List <Object> sveIzBaze();
    public Object izBazePremaId(int id);
}
