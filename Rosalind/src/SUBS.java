import edu.princeton.cs.algs4.Queue;

// Finds motifs in DNA sequence

public class SUBS {
	public static void main(String[] args) {
		String dnaSequence = "CAGTACTTCAGTACTCAGTACTCCAGTACTCAGTACTAACAGTACTTCCAGTACTAGATTCTCGACAGTACTCAGTACTCAGTACTCCAGCAGTACTTGCAGTACTTTGGTTCAGTACTCCCAGTACTCAGTACTAGCAGTACTCCAGTACTTTGCTGCGCAGTACTCAGTACTGGACAGTACTTTGACCAGTACTTTGGCAGTACTACAGTACTTACAGTACTCAGTACTACAGTACTCCCAGACAGTACTACAGTACTCAGTACTCCCCAGATCAGTACTTACTGAGGCAGTACTGCAGTACTCCAGATAACCAGTACTCCAGTACTCAGTACTGGCAGTACTCAGTACTCAGTACTCAGTACTCAGTACTATCAGTACTCAGTACTCGGCGGCCAGTACTACAGTACTGCAGTACTCCAGTACTAACAGTACTTGGAGCACAGTACTACAGTACTCAGTACTGGGCGATTACTCCCAGTACTCAGTACTTCAGTACTCAGTACTCATTCAGTACTCAGTACTTGCGGACAGTACTTCAGTACTCAGTACTTCGGACAGTACTATCGCAGTACTCAGTACTTCAGTACTTTGCAGTACTCCCTCAGTACTACCCAGTACTCGGGCAGTACTGTGGCAGTACTGCAGTACTGCCAGTACTTACAGTACTCAGTACTGGGACAGTACTTCTTCGGGACAGTACTAAACAGTACTAACATAACTCGCAGTACTCAGTACTTCTTCAGTACTATGCCAGTACTTCCAGTACTAGCAGTACTCAGTACTACAGTACTCAGTACTCAACTTAATGACAGTACTGAACAGTACTCAGTACTGGTACCCAAACACAGTACTTCCAGTACTCAGTACTTCCCAGTACTTCAGTACTCAGTACTACAGTACTATCT";
		String motif = "CAGTACTCA";
		
		
		Queue<Integer> motifPositions = new Queue<Integer>();
		
		int motifIndex = motif.length() - 1;
		int dnaIndex = motif.length() - 1;
		int positionIndex = motif.length() - 1;
		
		while(dnaIndex < dnaSequence.length())
		{
			if(motif.charAt(motifIndex) == dnaSequence.charAt(dnaIndex) && motifIndex == 0)
			{
				// Enqueuing dnaIndex + 1 b/c bio-sequences start at index of 1
				motifPositions.enqueue(dnaIndex + 1);
				dnaIndex = dnaIndex + motif.length();
				positionIndex = dnaIndex;
				motifIndex = motif.length() - 1;
			} else if (motif.charAt(motifIndex) == dnaSequence.charAt(dnaIndex))
			{
				motifIndex = motifIndex - 1;
				dnaIndex = dnaIndex - 1;
			} else
			{
				if(motif.indexOf(dnaSequence.charAt(dnaIndex)) == -1)
				{
					dnaIndex = dnaIndex + motif.length();
					positionIndex = dnaIndex;
					motifIndex = motif.length() - 1;
				} else if (motif.lastIndexOf(dnaSequence.charAt(dnaIndex)) > motifIndex)
				{
					dnaIndex = positionIndex + 1;
					positionIndex = dnaIndex;
					motifIndex = motif.length() - 1;
				} else
				{
					dnaIndex = positionIndex + motifIndex - motif.lastIndexOf(dnaSequence.charAt(dnaIndex));
					positionIndex = dnaIndex;
					motifIndex = motif.length() - 1;
				}
			}
			
		}
		
		for(Integer data: motifPositions)
		{
			System.out.print(data + " ");
		}
		
	
		
		
	}

}
