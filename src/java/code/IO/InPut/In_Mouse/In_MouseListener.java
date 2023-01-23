package code.IO.InPut.In_Mouse;

import code.Calc.Game.World.Coordinate;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class In_MouseListener implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
        Coordinate pos = new Coordinate(e.getX(), e.getY());

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}