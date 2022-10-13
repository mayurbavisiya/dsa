package dsa.strings;

import java.util.List;

public class Reverse {

	public static void main(String[] args) {

	}

	static final class BinRange {
		final String start;
		final String end;
		final String cardType;

		BinRange(String start, String end, String cardType) {
			this.start = start;
			this.end = end;
			this.cardType = cardType;
		}
	}

	interface CardTypeCache {
		/**
		 * @param cardNumber
		 *            12 to 23 digit card number.
		 * 
		 * @return the card type for this cardNumber or null if the card number
		 *         does not fall into any valid bin ranges.
		 */
		String get(String cardNumber);
	}

	public static CardTypeCache buildCache(List<BinRange> binRanges) {
		 return new CardTypeCache() {
		       
				@Override
				public String get(String cardNumber) {
					return null;
				}
		    };
	}
}
