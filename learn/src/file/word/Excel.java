package file.word;

import org.apache.poi.util.Removal;

/**
 * @author: wyj
 * @date: 2021/07/13
 */
public interface Excel {
    int CELL_TYPE_NUMERIC = 0;

    int CELL_TYPE_STRING = 1;

    int CELL_TYPE_FORMULA = 2;

    int CELL_TYPE_BLANK = 3;

    int CELL_TYPE_BOOLEAN = 4;

    int CELL_TYPE_ERROR = 5;
}
