/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.ImageView;

/**
 *
 * @author Tomáš
 */
public class MovesCheck {

    List<String> blacks;
    List<String> whites;

    public ArrayList checkMoves(int index, ArrayList<ImageView> tiles, ArrayList<String> images) {
        ArrayList<Integer> possibleMoves = new ArrayList();
        blacks = images.subList(1, 6);
        whites = images.subList(7, 12);
        if (tiles.get(index).getImage().toString().equals(images.get(1))) {
            return this.checkBishopBlack(index, tiles, images);
        } else if (tiles.get(index).getImage().toString().equals(images.get(2))) {
             return this.checkKingBlack(index, tiles, images);
        } else if (tiles.get(index).getImage().toString().equals(images.get(3))) {
            return this.checkKnightBlack(index, tiles, images);
        } else if (tiles.get(index).getImage().toString().equals(images.get(4))) {
            return this.checkPinchBlack(index, tiles, images);
        } else if (tiles.get(index).getImage().toString().equals(images.get(5))) {
            possibleMoves.addAll(this.checkTowerBlack(index, tiles, images));
            possibleMoves.addAll(this.checkBishopBlack(index, tiles, images));
            return possibleMoves;
        } else if (tiles.get(index).getImage().toString().equals(images.get(6))) {
            return this.checkTowerBlack(index, tiles, images);
        } else if (tiles.get(index).getImage().toString().equals(images.get(7))) {
            return this.checkBishopWhite(index, tiles, images);

        } else if (tiles.get(index).getImage().toString().equals(images.get(8))) {
            return this.checkKingWhite(index, tiles, images);
        } else if (tiles.get(index).getImage().toString().equals(images.get(9))) {
            return this.checkKnightWhite(index, tiles, images);
        } else if (tiles.get(index).getImage().toString().equals(images.get(10))) {
            return this.checkPinchWhite(index, tiles, images);
        } else if (tiles.get(index).getImage().toString().equals(images.get(11))) {
            possibleMoves.addAll(this.checkTowerWhite(index, tiles, images));
            possibleMoves.addAll(this.checkBishopWhite(index, tiles, images));
            return possibleMoves;
        } else if (tiles.get(index).getImage().toString().equals(images.get(12))) {
            return this.checkTowerWhite(index, tiles, images);
        }

        return possibleMoves;
    }

    //kontrola, jestli neni kral ohrozen
    private ArrayList notCheck() {
        return new ArrayList();
    }

    private ArrayList checkPinchBlack(int index, ArrayList<ImageView> tiles, ArrayList<String> images) {
        ArrayList possibleMoves = new ArrayList();
        if (tiles.get(index + 8).getImage().toString().equals(images.get(0))) {
            possibleMoves.add(index + 8);
            if (index < 16 && tiles.get(index + 16).getImage().toString().equals(images.get(0))) {
                possibleMoves.add(index + 16);
            }

        }
        if (whites.contains(tiles.get(index + 7).getImage().toString())) {
            possibleMoves.add(index + 7);
        }
        if (whites.contains(tiles.get(index + 9).getImage().toString())) {
            possibleMoves.add(index + 9);
        }
        return possibleMoves;
    }

    private ArrayList checkPinchWhite(int index, ArrayList<ImageView> tiles, ArrayList<String> images) {
        ArrayList possibleMoves = new ArrayList();
        if (tiles.get(index - 8).getImage().toString().equals(images.get(0))) {
            possibleMoves.add(index - 8);
            if ((index < 56 && index > 47) && tiles.get(index - 16).getImage().toString().equals(images.get(0))) {
                possibleMoves.add(index - 16);
            }

        }
        if (blacks.contains(tiles.get(index - 7).getImage().toString())) {
            possibleMoves.add(index - 7);
        }
        if (blacks.contains(tiles.get(index - 9).getImage().toString())) {
            possibleMoves.add(index - 9);
        }
        return possibleMoves;
    }

    private ArrayList checkTowerBlack(int index, ArrayList<ImageView> tiles, ArrayList<String> images) {
        ArrayList possibleMoves = new ArrayList();
        for (int i = 1; i < 8; i++) {

            if (index - 8 * i < 0 || index - 8 * (i - 1) % 8 == 0 || !tiles.get(index - 8 * (i - 1)).getImage().toString().equals(images.get(0)) || blacks.contains(tiles.get(index - 9 * i).getImage().toString())) {
                break;
            }
            possibleMoves.add(index - 8 * i);
        }

        for (int i = 1; i < 8; i++) {

            if (index - 1 * i < 0 || index - 1 * (i - 1) % 8 == 7 || !tiles.get(index - 1 * (i - 1)).getImage().toString().equals(images.get(0)) || blacks.contains(tiles.get(index - 7 * i).getImage().toString())) {
                break;
            }
            possibleMoves.add(index - 1 * i);
        }

        for (int i = 1; i < 8; i++) {

            if (index + 8 * i > 63 || index + 8 * (i - 1) % 8 == 0 || !tiles.get(index + 7 * (i - 1)).getImage().toString().equals(images.get(0)) || blacks.contains(tiles.get(index + 7 * i).getImage().toString())) {
                break;
            }
            possibleMoves.add(index + 8 * i);
        }

        for (int i = 1; i < 8; i++) {

            if (index + 1 * i > 63 || index + 9 * (i - 1) % 8 == 7 || !tiles.get(index + 9 * (i - 1)).getImage().toString().equals(images.get(0)) || blacks.contains(tiles.get(index + 9 * i).getImage().toString())) {
                break;
            }
            possibleMoves.add(index + 1 * i);
        }
        return possibleMoves;
    }

    private ArrayList checkTowerWhite(int index, ArrayList<ImageView> tiles, ArrayList<String> images) {
        ArrayList possibleMoves = new ArrayList();
        for (int i = 1; i < 8; i++) {

            if (index - 8 * i < 0 || index - 8 * (i - 1) % 8 == 0 || !tiles.get(index - 8 * (i - 1)).getImage().toString().equals(images.get(0)) || whites.contains(tiles.get(index - 9 * i).getImage().toString())) {
                break;
            }
            possibleMoves.add(index - 8 * i);
        }

        for (int i = 1; i < 8; i++) {

            if (index - 1 * i < 0 || index - 1 * (i - 1) % 8 == 7 || !tiles.get(index - 1 * (i - 1)).getImage().toString().equals(images.get(0)) || whites.contains(tiles.get(index - 7 * i).getImage().toString())) {
                break;
            }
            possibleMoves.add(index - 1 * i);
        }

        for (int i = 1; i < 8; i++) {

            if (index + 8 * i > 63 || index + 8 * (i - 1) % 8 == 0 || !tiles.get(index + 7 * (i - 1)).getImage().toString().equals(images.get(0)) || whites.contains(tiles.get(index + 7 * i).getImage().toString())) {
                break;
            }
            possibleMoves.add(index + 8 * i);
        }

        for (int i = 1; i < 8; i++) {

            if (index + 1 * i > 63 || index + 9 * (i - 1) % 8 == 7 || !tiles.get(index + 9 * (i - 1)).getImage().toString().equals(images.get(0)) || whites.contains(tiles.get(index + 9 * i).getImage().toString())) {
                break;
            }
            possibleMoves.add(index + 1 * i);
        }
        return possibleMoves;
    }

    private ArrayList checkKnightBlack(int index, ArrayList<ImageView> tiles, ArrayList<String> images) {
        ArrayList possibleMoves = new ArrayList();
        if (index - 17 >= 0 && index % 8 != 0 && !blacks.contains(tiles.get(index - 17).getImage().toString())) {
            possibleMoves.add(index - 17);
        }
        if (index - 15 >= 0 && index % 8 != 7 && !blacks.contains(tiles.get(index - 15).getImage().toString())) {
            possibleMoves.add(index - 15);
        }
        if (index - 10 >= 0 && index % 8 > 1 && !blacks.contains(tiles.get(index - 10).getImage().toString())) {
            possibleMoves.add(index - 10);
        }
        if (index - 6 >= 0 && index % 8 < 6 && !blacks.contains(tiles.get(index - 6).getImage().toString())) {
            possibleMoves.add(index - 6);
        }
        if (index + 6 < 64 && index % 8 > 1 && !blacks.contains(tiles.get(index + 6).getImage().toString())) {
            possibleMoves.add(index + 6);
        }
        if (index + 10 < 64 && index % 8 < 6 && !blacks.contains(tiles.get(index + 10).getImage().toString())) {
            possibleMoves.add(index + 10);
        }
        if (index + 15 < 64 && index % 8 != 0 && !blacks.contains(tiles.get(index + 15).getImage().toString())) {
            possibleMoves.add(index + 15);
        }
        if (index + 17 < 64 && index % 8 != 7 && !blacks.contains(tiles.get(index + 17).getImage().toString())) {
            possibleMoves.add(index + 17);
        }
        return possibleMoves;
    }

    private ArrayList checkKnightWhite(int index, ArrayList<ImageView> tiles, ArrayList<String> images) {
        ArrayList possibleMoves = new ArrayList();
        if (index - 17 >= 0 && index % 8 != 0 && !whites.contains(tiles.get(index - 17).getImage().toString())) {
            possibleMoves.add(index - 17);
        }
        if (index - 15 >= 0 && index % 8 != 7 && !whites.contains(tiles.get(index - 15).getImage().toString())) {
            possibleMoves.add(index - 15);
        }
        if (index - 10 >= 0 && index % 8 > 1 && !whites.contains(tiles.get(index - 10).getImage().toString())) {
            possibleMoves.add(index - 10);
        }
        if (index - 6 >= 0 && index % 8 < 6 && !whites.contains(tiles.get(index - 6).getImage().toString())) {
            possibleMoves.add(index - 6);
        }
        if (index + 6 < 64 && index % 8 > 1 && !whites.contains(tiles.get(index + 6).getImage().toString())) {
            possibleMoves.add(index + 6);
        }
        if (index + 10 < 64 && index % 8 < 6 && !whites.contains(tiles.get(index + 10).getImage().toString())) {
            possibleMoves.add(index + 10);
        }
        if (index + 15 < 64 && index % 8 != 0 && !whites.contains(tiles.get(index + 15).getImage().toString())) {
            possibleMoves.add(index + 15);
        }
        if (index + 17 < 64 && index % 8 != 7 && !whites.contains(tiles.get(index + 17).getImage().toString())) {
            possibleMoves.add(index + 17);
        }
        return possibleMoves;
    }

    private ArrayList checkBishopBlack(int index, ArrayList<ImageView> tiles, ArrayList<String> images) {
        ArrayList possibleMoves = new ArrayList();
        for (int i = 1; i < 8; i++) {

            if (index - 9 * i < 0 || index - 9 * (i - 1) % 8 == 0 || !tiles.get(index - 9 * (i - 1)).getImage().toString().equals(images.get(0)) || blacks.contains(tiles.get(index - 9 * i).getImage().toString())) {
                break;
            }
            possibleMoves.add(index - 9 * i);
        }

        for (int i = 1; i < 8; i++) {

            if (index - 7 * i < 0 || index - 7 * (i - 1) % 8 == 7 || !tiles.get(index - 7 * (i - 1)).getImage().toString().equals(images.get(0)) || blacks.contains(tiles.get(index - 7 * i).getImage().toString())) {
                break;
            }
            possibleMoves.add(index - 7 * i);
        }

        for (int i = 1; i < 8; i++) {

            if (index + 7 * i > 63 || index + 7 * (i - 1) % 8 == 0 || !tiles.get(index + 7 * (i - 1)).getImage().toString().equals(images.get(0)) || blacks.contains(tiles.get(index + 7 * i).getImage().toString())) {
                break;
            }
            possibleMoves.add(index + 7 * i);
        }

        for (int i = 1; i < 8; i++) {

            if (index + 9 * i > 63 || index + 9 * (i - 1) % 8 == 7 || !tiles.get(index + 9 * (i - 1)).getImage().toString().equals(images.get(0)) || blacks.contains(tiles.get(index + 9 * i).getImage().toString())) {
                break;
            }
            possibleMoves.add(index + 9 * i);
        }
        return possibleMoves;
    }

    private ArrayList checkBishopWhite(int index, ArrayList<ImageView> tiles, ArrayList<String> images) {
        ArrayList possibleMoves = new ArrayList();
        for (int i = 1; i < 8; i++) {

            if (index - 9 * i < 0 || index - 9 * (i - 1) % 8 == 0 || !tiles.get(index - 9 * (i - 1)).getImage().toString().equals(images.get(0)) || whites.contains(tiles.get(index - 9 * i).getImage().toString())) {
                break;
            }
            possibleMoves.add(index - 9 * i);
        }

        for (int i = 1; i < 8; i++) {

            if (index - 7 * i < 0 || index - 7 * (i - 1) % 8 == 7 || !tiles.get(index - 7 * (i - 1)).getImage().toString().equals(images.get(0)) || whites.contains(tiles.get(index - 7 * i).getImage().toString())) {
                break;
            }
            possibleMoves.add(index - 7 * i);
        }

        for (int i = 1; i < 8; i++) {

            if (index + 7 * i > 63 || index + 7 * (i - 1) % 8 == 0 || !tiles.get(index + 7 * (i - 1)).getImage().toString().equals(images.get(0)) || whites.contains(tiles.get(index + 7 * i).getImage().toString())) {
                break;
            }
            possibleMoves.add(index + 7 * i);
        }

        for (int i = 1; i < 8; i++) {

            if (index + 9 * i > 63 || index + 9 * (i - 1) % 8 == 7 || !tiles.get(index + 9 * (i - 1)).getImage().toString().equals(images.get(0)) || whites.contains(tiles.get(index + 9 * i).getImage().toString())) {
                break;
            }
            possibleMoves.add(index + 9 * i);
        }
        return possibleMoves;
    }

    private ArrayList checkKingBlack(int index, ArrayList<ImageView> tiles, ArrayList<String> images) { //opravit IndexOutOfBoundsException
        ArrayList possibleMoves = new ArrayList();
        for (int i = 0; i < 3; i++) {
            if ( &&index-9+i>0&&!blacks.contains(tiles.get(index - 9 + i).getImage().toString())) {
                possibleMoves.add(index - 9 + i);
            }
            if (!blacks.contains(tiles.get(index + 7 + i).getImage().toString())) {
                possibleMoves.add(index + 7 + i);
            }
        }
        if (!blacks.contains(tiles.get(index - 1).getImage().toString())) {
            possibleMoves.add(index - 1);
        }
        if (!blacks.contains(tiles.get(index + 1).getImage().toString())) {
            possibleMoves.add(index - 1);
        }
        return possibleMoves;
    }

    private ArrayList checkKingWhite(int index, ArrayList<ImageView> tiles, ArrayList<String> images) {
        ArrayList possibleMoves = new ArrayList();
         for (int i = 0; i < 3; i++) {
            if (index-9+i>0&&!whites.contains(tiles.get(index - 9 + i).getImage().toString())) {
                possibleMoves.add(index - 9 + i);
            }
            if (!whites.contains(tiles.get(index + 7 + i).getImage().toString())) {
                possibleMoves.add(index + 7 + i);
            }
        }
        if (!whites.contains(tiles.get(index - 1).getImage().toString())) {
            possibleMoves.add(index - 1);
        }
        if (!whites.contains(tiles.get(index + 1).getImage().toString())) {
            possibleMoves.add(index - 1);
        }

        return possibleMoves;
    }

}
