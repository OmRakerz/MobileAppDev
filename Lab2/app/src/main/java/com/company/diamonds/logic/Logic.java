package com.company.diamonds.logic;

import com.company.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        // TODO -- add your code here
        
        int height_count = 0;
        int size_count = size + 1;

        // Цикл по строкам ромба
        for (int height = 0; height < size * 2 + 1; height++) {
            // Цикл по столбцам ромба
            for (int width = 0; width < size * 2 + 2; width++) {
                // Проверка, является ли текущая позиция углом ромба
                if ((height == 0 || height == size * 2) && (width == 0 || width == size * 2 + 1)) {
                    mOut.print('+');
                }

                // Проверка, является ли текущая позиция вертикальной стороной ромба
                else if ((height != 0 || height != size * 2) && (width == 0 || width == size * 2 + 1)) {
                    mOut.print('|');
                }

                // Проверка, является ли текущая позиция горизонтальной стороной ромба
                else if ((height == 0 || height == size * 2) && (width != 0 || width != size * 2 + 1)) {
                    mOut.print('-');
                }

                // Проверка, является ли текущая позиция внутренней частью ромба
                else if ((height != 0 || height != size * 2) && (width != 0 || width != size * 2 + 1)) {
                    // Проверка, является ли текущая позиция серединой ромба
                    if (height == Math.ceil((size * 2 + 1) / 2)) {
                        if (width == 1) {
                            mOut.print('<'); // Вставка '<' в начало середины
                        } else if (width == size * 2) {
                            mOut.print('>'); // Вставка '>' в конец середины
                        } else {
                            if (height % 2 == 0) {
                                mOut.print('-'); // Вывод '-' для четных позиций высоты в середине
                            } else {
                                mOut.print('=');
                            }
                        }
                    }

                    // Проверка, является ли текущая позиция выше середины ромба
                    else if (height < Math.ceil((size * 2 + 1) / 2)) {

                        // Проверка, является ли текущая позиция слева от ромба
                        if (width <= size) {
                            if (width == size_count) {
                                mOut.print('/'); // Вставка '/' влевую границу ромба
                            } else if (width > size_count) {
                                if (height % 2 == 0) {
                                    mOut.print('-'); // Вывод '-' для четных позиций высоты слева от ромба
                                } else {
                                    mOut.print('=');
                                }
                            } else {
                                mOut.print(' '); // Вставка пробела для остальной левой части ромба
                            }
                        }

                        // Проверка, является ли текущая позиция справа от ромба
                        else if (width > size) {
                            if (width == size + height_count) {
                                mOut.print('\\'); // Вставка '\' вправую границу ромба
                            } else if (width < size + height_count) {
                                if (height % 2 == 0) {
                                    mOut.print('-'); // Вывод '-' для четных позиций высоты справа от ромба
                                } else {
                                    mOut.print('=');
                                }
                            } else {
                                mOut.print(' '); // Вставка пробела для остальной правой части ромба
                            }
                        }
                    }

                    // Проверка, является ли текущая позиция ниже середины ромба
                    else if (height > Math.ceil((size * 2 + 1) / 2)) {
                        // Проверка, является ли текущая позиция слева от ромба
                        if (width <= size) {
                            if (width == size_count) {
                                mOut.print('\\'); // Вставка '\' влевую границу ромба
                            } else if (width > size_count) {
                                if (height % 2 == 0) {
                                    mOut.print('-'); // Вывод '-' для четных позиций высоты слева от ромба
                                } else {
                                    mOut.print('=');
                                }
                            } else {
                                mOut.print(' '); // Вставка пробела для остальной левой части ромба
                            }
                        }

                        // Проверка, является ли текущая позиция справа от ромба
                        else if (width > size) {
                            if (width == size + height_count) {
                                mOut.print('/'); // Вставка '/' вправую границу ромба
                            } else if (width < size + height_count) {
                                if (height % 2 == 0) {
                                    mOut.print('-'); // Вывод '-' для четных позиций высоты справа от ромба
                                } else {
                                    mOut.print('=');
                                }
                            } else {
                                mOut.print(' '); // Вставка пробела для остальной правой части ромба
                            }
                        }
                    }
                }
            }

            // Переход на следующую строку после каждой строки ромба
            mOut.print('\n');

            // Обновление счетчиков высоты и размера для следующей строки
            if (height < size) {
                ++height_count;
                --size_count;
            } else {
                --height_count;
                ++size_count;
            }
        }
    }

}    
