package search;

import java.io.*;

public class BoardGenerator
{
	private static BoardGenerator instance;
	
	private BoardGenerator()
	{
		
	}
	
	public Board generateFromIntArray(char[][] input)
	{
		AState[][] map = new AState[input.length][input[0].length];
		
		for(int rowNum = 0; rowNum < input.length; rowNum++)
		{
			for(int colNum = 0; colNum < input[rowNum].length; colNum++)
			{
				boolean block = input[rowNum][colNum] == 1;
				boolean start = input[rowNum][colNum] == 2;
				boolean goal = input[rowNum][colNum] == 3;
				
				map[rowNum][colNum] = new AState(colNum, rowNum, block, start, goal);
			}
		}
		
		return new Board(map);
	}
	
	public Board generateFromCharArray(char[][] input)
	{
		AState[][] map = new AState[input.length][input[0].length];
		
		for(int rowNum = 0; rowNum < input.length; rowNum++)
		{
			for(int colNum = 0; colNum < input[rowNum].length; colNum++)
			{
				boolean block = input[rowNum][colNum] == 'x';
				boolean start = input[rowNum][colNum] == 's';
				boolean goal = input[rowNum][colNum] == 'g';
				
				map[rowNum][colNum] = new AState(colNum, rowNum, block, start, goal);
			}
		}
		
		return new Board(map);
	}
	
	public Board generateFromStringArray(String[][] input)
	{
		AState[][] map = new AState[input.length][input[0].length];
		
		for(int rowNum = 0; rowNum < input.length; rowNum++)
		{
			for(int colNum = 0; colNum < input[rowNum].length; colNum++)
			{
				boolean block = input[rowNum][colNum].equals("x");
				boolean start = input[rowNum][colNum].equals("s");
				boolean goal = input[rowNum][colNum].equals("g");
				
				map[rowNum][colNum] = new AState(colNum, rowNum, block, start, goal);
			}
		}
		
		return new Board(map);
	}
	
	public Board generateFromFile(String path)
	{
		try
		{
			FileInputStream fstream = new FileInputStream(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			
			String line = br.readLine();
			
			int size = Integer.parseInt(line);
			
			AState[][] map = new AState[size][size];
			line = br.readLine();
			int rowNum = 0;
			while(line != null && rowNum < size)
			{
				for(int colNum = 0; colNum < line.length() && colNum < size; colNum++)
				{
					char symbol = line.charAt(colNum);
					map[rowNum][colNum] = new AState(colNum, rowNum, symbol == 'x', symbol == 's', symbol == 'g');
				}
				
				rowNum++;
				line = br.readLine();
			}
			
			br.close();
			
			return new Board(map);
		}
		catch(IOException ex)
		{
			System.out.print("The input file doesn't exist " + ex.getMessage());
		}
		catch(NumberFormatException ex)
		{
			System.out.print(ex.getMessage());
		}
		
		return null;
	}
	
	public Board generateRandom(int size, double limitProb)
	{
		AState[][] map = new AState[size][size];
		map[0][0] = new AState(0,0, false, true, false);
		map[size-1][size-1] = new AState(size-1, size-1, false, false, true);
		
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				if(i == 0 && j == 0)
					continue;
				else if(i == size - 1 && j == size -1)
					continue;
				
				double prob = Math.random();
				map[i][j] = new AState(j, i, prob <= limitProb, false, false);
			}
		}
		
		return new Board(map);
	}
	
	public static BoardGenerator getInstance()
	{
		if(instance == null)
			instance = new BoardGenerator();
		
		return instance;
	}
}
