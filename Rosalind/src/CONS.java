
import java.util.Scanner;

public class CONS {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many sequences?");
		int sequenceNumber = in.nextInt();
		
		System.out.println("Sequence length?");
		int sequenceLength = in.nextInt();
		
		int [][] frequency = new int[4][sequenceLength];
		
		for(int i = 1; i <= sequenceNumber; i++)
		{
			System.out.println("Enter sequence " + i);
			String sequence = in.next();
			for(int j = 0; j < sequence.length(); j++)
			{
				char c = sequence.charAt(j);
				if(c == 'A')
				{
					frequency[0][j]++;
				} else if (c == 'C')
				{
					frequency[1][j]++;
				}  else if (c == 'G')
				{
					frequency[2][j]++;
				}  else if (c == 'T')
				{
					frequency[3][j]++;
				}
			}
		}
		
		in.close();
		
		String consensus = "";
		for(int i = 0; i < frequency[0].length; i++)
		{
			int letter = 0;
			for(int j = 1; j < frequency.length; j++)
			{
				if(frequency[j][i] > frequency[letter][i])
				{
					letter = j;
				}
			}
			if(letter == 0)
			{
				consensus += "A";
			} else if (letter == 1)
			{
				consensus += "C";
			} else if (letter == 2)
			{
				consensus += "G";
			} else if (letter == 3)
			{
				consensus += "T";
			}
		}
		
		System.out.println(consensus);
		
		System.out.print("A: ");
		for(int data: frequency[0])
		{
			System.out.print(data + " ");
		}
		
		System.out.println();
		
		System.out.print("C: ");
		for(int data: frequency[1])
		{
			System.out.print(data + " ");
		}
		
		System.out.println();
		
		System.out.print("G: ");
		for(int data: frequency[2])
		{
			System.out.print(data + " ");
		}
		
		System.out.println();
		
		System.out.print("T: ");
		for(int data: frequency[3])
		{
			System.out.print(data + " ");
		}
		
		
		
		
		
		
		
		
	}
}
