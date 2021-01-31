package com.kata.token;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

import com.kata.Arguments;

/**
 * @author sunjing
 */
public final class ArgumentTokenizer {

    private static final String TOKEN_FLAG_PREFIX = "-";

    private final Queue<String> tokens = new LinkedList<>();

    public ArgumentTokenizer(final String commandLine) {
        this.tokens.addAll(toTokens(commandLine));
    }

    private List<String> toTokens(final String commandLine) {
        return Arrays.asList(commandLine.split(" "));
    }

    public Arguments arguments() {
        final Arguments arguments = new Arguments();
        while (hasNext()) {
            String token = poll();
            if (isNoTokenValue()) {
                arguments.add(tokenToFlag(token), Optional.empty());
                continue;
            }

            String tokenValue = poll();
            arguments.add(tokenToFlag(token), Optional.of(tokenValue));
        }

        return arguments;
    }

    private Boolean hasNext() {
        return !tokens.isEmpty();
    }

    private String poll() {
        return tokens.poll();
    }

    private Boolean isNoTokenValue() {
        String nextToken = tokens.peek();
        return nextToken == null || nextToken.startsWith(TOKEN_FLAG_PREFIX);
    }

    private String tokenToFlag(String token) {
        return token.replace(TOKEN_FLAG_PREFIX, "");
    }
}
