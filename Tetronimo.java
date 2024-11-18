public class Tetronimo {
   public static final int[][][][][] possiblePlacements = {
        // J Tetronimos
        {
            // 0:Right
            {
                // Start from square 0
                {{1, 0}, {2, 0}, {2, -1}},
                // Start from square 1
                {{-1, 0}, {1, 0}, {1, -1}},
                // Start from square 2
                {{-2, 0}, {-1, 0}, {0, -1}},
                // Start from square 3
                {{-2, 1}, {-1, 1}, {0, 1}}
            },
            // 1:Up
            {
                // Start from square 0
                {{0, 1}, {0, 2}, {1, 2}},
                // Start from square 1
                {{0, -1}, {0, 1}, {1, 1}},
                // Start from square 2
                {{0, -2}, {0, -1}, {1, 0}},
                // Start from square 3
                {{-1, -2}, {-1, -1}, {-1, 0}}
            },
            // 2:Left
            {
                // Start from square 0
                {{-1, 0}, {-2, 0}, {-2, 1}},
                // Start from square 1
                {{1, 0}, {-1, 0}, {-1, 1}},
                // Start from square 2
                {{2, 0}, {1, 0}, {0, 1}},
                // Start from square 3
                {{2, -1}, {1, -1}, {0, -1}}
            },
            // 3:Down
            {
                // Start from square 0
                {{0, -1}, {0, -2}, {-1, -2}},
                // Start from square 1
                {{0, 1}, {0, -1}, {-1, -1}},
                // Start from square 2
                {{0, 2}, {0, 1}, {-1, 0}},
                // Start from square 3
                {{1, 2}, {1, 1}, {1, 0}}
            },
        },

        // L Tetronimos
        {
            // 0:Right
            {
                // Start from square 0
                {{1, 0}, {2, 0}, {2, 1}},
                // Start from square 1
                {{-1, 0}, {1, 0}, {1, 1}},
                // Start from square 2
                {{-2, 0}, {-1, 0}, {0, 1}},
                // Start from square 3
                {{-2, -1}, {-1, -1}, {0, -1}}
            },
            // 1:Up
            {
                // Start from square 0
                {{0, 1}, {0, 2}, {-1, 2}},
                // Start from square 1
                {{0, -1}, {0, 1}, {-1, 1}},
                // Start from square 2
                {{0, -2}, {0, -1}, {-1, 0}},
                // Start from square 3
                {{1, -2}, {1, -1}, {1, 0}}
            },
            // 2:Left
            {
                // Start from square 0
                {{-1, 0}, {-2, 0}, {-2, -1}},
                // Start from square 1
                {{1, 0}, {-1, 0}, {-1, -1}},
                // Start from square 2
                {{2, 0}, {1, 0}, {0, -1}},
                // Start from square 3
                {{2, 1}, {1, 1}, {0, 1}}
            },
            // 3:Down
            {
                // Start from square 0
                {{0, -1}, {0, -2}, {1, -2}},
                // Start from square 1
                {{0, 1}, {0, -1}, {1, -1}},
                // Start from square 2
                {{0, 2}, {0, 1}, {1, 0}},
                // Start from square 3
                {{-1, 2}, {-1, 1}, {-1, 0}}
            },
        }
    };  
}