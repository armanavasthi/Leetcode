class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        
        int prev = cells[0];
        
        cells[0] = 0;
        
        // day 1 handled separately as its need first and last values of arrray to be 0
        prev = todaysChanges(prev, cells);
        
        // Pattern repeats after every 14 days
        N = (N-1)%14;
        
        for (int i = 0; i < N; i++) {
            prev = todaysChanges(prev, cells);  
        }
        return cells;
    }
    
    public int todaysChanges(int prev, int[] cells) {
        for(int j = 1; j < 7; j++) {
                if(prev == cells[j+1]) {
                    prev = cells[j];
                    cells[j] = 1;
                }
                else {
                    prev = cells[j];
                    cells[j] = 0;
                }
                if(j == 6) {
                    // Last cell will always be 0
                    // Can be improved by doing cells[7] = 0 only once
                    cells[j+1] = 0;
                    prev = cells[0];
                }
        }
        return prev;
    }
}
