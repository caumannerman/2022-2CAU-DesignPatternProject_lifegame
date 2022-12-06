package com.holub.life;

import java.awt.*;
import javax.swing.*;

import com.holub.life.cellcolor.BlueCellColor;
import com.holub.life.cellcolor.CellColor;
import com.holub.life.cellcolor.GreenCellColor;
import com.holub.life.cellcolor.RedCellColor;
import com.holub.ui.Colors;	// Contains constants specifying various
							// colors not defined in java.awt.Color.
import com.holub.life.Cell;
import com.holub.life.Storable;
import com.holub.life.Direction;
import com.holub.life.Neighborhood;
import com.holub.life.Universe;

/*** ****************************************************************
 * The Resident class implements a single cell---a "resident" of a
 * block.
 *
 * @include /etc/license.txt
 */

public final class Resident  implements Cell
{
//	private static final Color BORDER_COLOR = Colors.DARK_YELLOW;
//	private static final Color LIVE_COLOR 	= Colors.LIGHT_RED;
//	private static final Color DEAD_COLOR   = Colors.LIGHT_YELLOW;
//    private static final Color NOW_ALIVED_COLOR = Colors.LIGHT_GREEN;
//    private static final Color NOW_DEAD_COLOR = Colors.DARK_BLUE;

//	private CellColor cellColor = new CellColor(Colors.DARK_YELLOW, Colors.LIGHT_RED, Colors.LIGHT_YELLOW, Colors.LIGHT_GREEN, Colors.DARK_BLUE);
	private CellColor cellColor = new GreenCellColor();

	private CellColor cellColor1 = new BlueCellColor();
	private CellColor cellColor2 = new RedCellColor();
	private CellColor cellColor3 = new GreenCellColor();
	private CellColor[] cellColors = {cellColor1, cellColor2, cellColor3};

	private int now_idx = 0;
	public static int ccount = 0;
    public static int ccount_base = 30;

	private boolean amAlive 	= false;
	private boolean willBeAlive	= false;
	private boolean now_Alived = false;
	private boolean now_Dead = false;

	private boolean isStable(){return amAlive == willBeAlive; }

	/** figure the next state.
	 *  @return true if the cell is not stable (will change state on the
	 *  next transition().
	 */
	public boolean figureNextState(
							Cell north, 	Cell south,
							Cell east, 		Cell west,
							Cell northeast, Cell northwest,
							Cell southeast, Cell southwest )
	{
		verify( north, 		"north"		);
		verify( south, 		"south"		);
		verify( east, 		"east"		);
		verify( west, 		"west"		);
		verify( northeast,	"northeast"	);
		verify( northwest,	"northwest" );
		verify( southeast,	"southeast" );
		verify( southwest,	"southwest" );

		int neighbors = 0;

		if( north.	  isAlive()) ++neighbors;
		if( south.	  isAlive()) ++neighbors;
		if( east. 	  isAlive()) ++neighbors;
		if( west. 	  isAlive()) ++neighbors;
		if( northeast.isAlive()) ++neighbors;
		if( northwest.isAlive()) ++neighbors;
		if( southeast.isAlive()) ++neighbors;
		if( southwest.isAlive()) ++neighbors;

		//jsjs
		// 이제 막 alive된 것은 now_alived = true 해준다.
		// 원래부터 살아있었던 것은 제외

		willBeAlive = (neighbors==3 || (amAlive && neighbors==2));
		return !isStable();
	}

	private void verify( Cell c, String direction )
	{	assert (c instanceof Resident) || (c == Cell.DUMMY)
				: "incorrect type for " + direction +  ": " +
				   c.getClass().getName();
	}

	/** This cell is monetary, so it's at every edge of itself. It's
	 *  an internal error for any position except for (0,0) to be
	 *  requsted since the width is 1.
	 */
	public Cell	edge(int row, int column)
	{	assert row==0 && column==0;
		return this;
	}

	//jsjs
	// 여기서 amAlive에 willBeAlive를 전달해줌
	public boolean transition()
	{	boolean changed = isStable();
	    //jsjs
		// 죽어있었고, 이번에 살아나는 것을 state전달해주며, 방금 살아났다는 체크를 now_Alived = true를 통해 해줌
	    if(!amAlive && willBeAlive){
	    	now_Alived = true;
			now_Dead = false;
		}
	    //살아있었는데 죽는 것들은 now_Dead처
	    else if(amAlive && !willBeAlive){
	    	now_Dead = true;
			now_Alived = false;
		}
	    else{
	    	now_Alived = false;
			now_Dead = false;
		}
		amAlive = willBeAlive;
		//jsjs
		// 방금 amAlive된 것을
        ccount += 1;

        if(ccount % ccount_base == 0){
			cellColor = cellColors[now_idx];
			now_idx += 1;
			if(now_idx == 3){
				now_idx = 0;
			}
		}
		return changed;
	}

	public void redraw(Graphics g, Rectangle here, boolean drawAll)
    {   g = g.create();
        //jsjs
		// now_Alive상태라면 그에 맞는 color를 적용해준다.
        if(amAlive){
			g.setColor(now_Alived ? cellColor.getNOW_ALIVED_COLOR() :  cellColor.getLIVE_COLOR() );
		}
        else{
			g.setColor( now_Dead ?  cellColor.getNOW_DEAD_COLOR() :  cellColor.getDEAD_COLOR());
		}

		g.fillRect(here.x+1, here.y+1, here.width-1, here.height-1);

		// Doesn't draw a line on the far right and bottom of the
		// grid, but that's life, so to speak. It's not worth the
		// code for the special case.

		g.setColor(  cellColor.getBORDER_COLOR() );
		g.drawLine( here.x, here.y, here.x, here.y + here.height );
		g.drawLine( here.x, here.y, here.x + here.width, here.y  );
		g.dispose();
	}

	public void userClicked(Point here, Rectangle surface)
	{	amAlive = !amAlive;
	    //jsjs
		//사용자가 now_Alived상태의 cell을 지웠다가 다시 클릭했을 때, 새롭게 만들어질 때와 같은 색으로 표현하기 위해 now_Alived는 false처리한다.
		if(!amAlive){
			now_Alived = false;
		}

	}

	public void	   clear()			{amAlive = willBeAlive = false; }
	public boolean isAlive()		{return amAlive;			    }
	public Cell    create()			{return new Resident();			}
	public int 	   widthInCells()	{return 1;}

	public Direction isDisruptiveTo()
	{	return isStable() ? Direction.NONE : Direction.ALL ;
	}

	public boolean transfer(Storable blob,Point upperLeft,boolean doLoad)
	{
		Memento memento = (Memento)blob;
		if( doLoad )
		{	if( amAlive = willBeAlive = memento.isAlive(upperLeft) )
				return true;
		}
		else if( amAlive )  					// store only live cells
			memento.markAsAlive( upperLeft );

		return false;
	}

	/** Mementos must be created by Neighborhood objects. Throw an
	 *  exception if anybody tries to do it here.
	 */
	public Storable createMemento()
	{	throw new UnsupportedOperationException(
					"May not create memento of a unitary cell");
	}
}
