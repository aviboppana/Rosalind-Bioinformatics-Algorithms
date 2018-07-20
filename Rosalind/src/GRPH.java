import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class GRPH {

	public static void main(String[] args) {
		In dna = new In("dna.txt");
		String[] dnaArray = dna.readAllLines();

		String[] dnaString = new String[dnaArray.length / 3];
		String[] dnaNames = new String[dnaString.length];

		int count = 0;
		for (int i = 0; i < dnaString.length; i++) {
			dnaString[i] = dnaArray[count + 1] + dnaArray[count + 2];
			dnaNames[i] = dnaArray[count];
			count = count + 3;
		}

		for (String data : dnaNames) {
			System.out.println(data);
		}

		for (String data : dnaString) {
			System.out.println(data);
		}

		Queue<Integer>[] list = new Queue[dnaString.length];

		for (int i = 0; i < dnaString.length; i++) {
			list[i] = new Queue<Integer>();
			for (int j = 0; j < dnaString.length; j++) {
				if(i != j)
				{
					if (dnaString[i].substring(dnaString[i].length() - 3).equals(dnaString[j].substring(0, 3))) {
						System.out.println(list[i]);
						list[i].enqueue(j);
					}
				}
				

			}
		}

		int count1 = 0;
		for (Queue<Integer> data : list) {
			System.out.print(count1 + ": ");
			for (Integer data1 : data) {
				System.out.print(data1 + " ");
			}

			System.out.println();
			count1++;
		}

		for (int i = 0; i < list.length; i++) {
			if (!list[i].isEmpty()) {
				for (Integer data : list[i]) {
					if (i != data) {
						System.out.println(dnaNames[i].substring(1) + " " + dnaNames[data].substring(1));
					}
				}
			}

		}

	}
}
