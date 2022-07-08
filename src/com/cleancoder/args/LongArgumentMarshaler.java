package com.cleancoder.args;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.cleancoder.args.ArgsException.ErrorCode.INVALID_INTEGER;
import static com.cleancoder.args.ArgsException.ErrorCode.MISSING_INTEGER;

public class LongArgumentMarshaler implements ArgumentMarshaler {
    private long longValue = 0;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            longValue = Long.parseLong(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_INTEGER);
        } catch (NumberFormatException e) {
            throw new ArgsException(INVALID_INTEGER, parameter);
        }
    }

    public static long getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof LongArgumentMarshaler)
            return ((LongArgumentMarshaler) am).longValue;
        else
            return 0;
    }
}
