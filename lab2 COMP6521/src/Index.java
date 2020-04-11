import java.util.HashMap;

import com.googlecode.javaewah.EWAHCompressedBitmap;
import com.reinaldoarrosi.bitmapindex.BIKey;
import com.reinaldoarrosi.bitmapindex.BIKey.BIGroup;

public class Index {

	private HashMap<BIKey, EWAHCompressedBitmap> bitmaps;
	private HashMap<BIGroup, EWAHCompressedBitmap> emptyBitmaps;
}
