
public class Josephus_Problem {
	public static void execute(int count) {
		int[] ring = new int[count];
		for (int i = 0; i < ring.length; i++) {
			ring[i] = i + 1;
		}
		while (ring.length > 1) {
			ring = killNext(ring);
		}
		System.out.println("Survivor is #" + ring[0]);
	}

	private static int[] killNext(int[] ring) {
		return ring.length % 2 == 0 ? cancelEven(ring) : cancelOdd(ring);
	}

	private static int[] cancelEven(int[] ring) {
		int numberOfSurvivors = ring.length / 2;
		int[] survivors = new int[numberOfSurvivors];
		for (int i = 0; i < survivors.length; i++) {
			survivors[i] = ring[i * 2];
		}
		return survivors;
	}

	private static int[] cancelOdd(int[] ring) {
		int numberOfSurvivors = ((int) (ring.length / 2)) + 1;
		int[] survivors = new int[numberOfSurvivors];
		for (int i = 0; i < survivors.length; i++) {
			survivors[i] = ring[i * 2];
		}
		return shift(survivors);
	}

	private static int[] shift(int[] ring) {
		int[] newRing = new int[ring.length];
		newRing[0] = ring[ring.length - 1];
		for (int i = 1; i < newRing.length; i++) {
			newRing[i] = ring[i - 1];
		}
		return newRing;
	}
}
