package FillingBookcaseShelves;

class Solution {
    public static void main(String[] args) {
        int[][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        System.out.println(new Solution().minHeightShelves(books,4));
    }

    public int minHeightShelves(int[][] books, int shelf_width) {
        int result = 0;
        quickSort(books, 0, books.length - 1);

        int remained_book_num = books.length;
        boolean[] used_books = new boolean[books.length];
        int use_width = 0;

        while (remained_book_num > 0) {
            int max = 0;

            for (int i = 0; i < books.length && remained_book_num > 0 && use_width < shelf_width; i++) {
                if (!used_books[i] && use_width + books[i][0] <= shelf_width) {
                    used_books[i] = true;
                    use_width += books[i][0];
                    remained_book_num--;

                    if (books[i][1] > max) {
                        max = books[i][1];
                    }
                    System.out.print(books[i][1] + " ");
                }
            }

            System.out.println();

            result += max;
            max = 0;
            use_width = 0;
        }

        return result;
    }

    public void quickSort(int[][] books,int low,int high) {
        if (low < high) {
            int partition = partition(books, low, high);
            quickSort(books, low, partition - 1);
            quickSort(books, partition + 1, high);
        }
    }

    public int partition(int[][] books,int low,int high) {
        int povit = books[low][1];
        int[] povit_elem = books[low];

        while (low < high) {
            while (low < high && books[high][1] >= povit) {
                high--;
            }
            books[low] = books[high];

            while (low < high && books[low][1] <= povit) {
                low++;
            }
            books[high] = books[low];
        }

        books[low] = povit_elem;

        return low;
    }
}