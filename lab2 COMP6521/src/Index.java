import java.util.BitSet;
import java.util.HashMap;

public class Index {
	
	private HashMap<BitMap.BIKey, BitSet> bitmaps;
	public Index() {
		bitmaps = new HashMap<BitMap.BIKey, BitSet>();
	}
	
	public void set(BitMap.BIKey key) {
		BitSet bitset = bitmaps.get(key);
		
		if(bitset == null) {
			bitset = new BitSet();
			bitmaps.put(key, bitset);
		}
     }
	
	
}
