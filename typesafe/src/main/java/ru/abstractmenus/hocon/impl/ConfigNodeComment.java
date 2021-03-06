package ru.abstractmenus.hocon.impl;


import ru.abstractmenus.hocon.ConfigException;

final class ConfigNodeComment extends ConfigNodeSingleToken {
    ConfigNodeComment(Token comment) {
        super(comment);
        if (!Tokens.isComment(super.token)) {
            throw new ConfigException.BugOrBroken("Tried to create a ConfigNodeComment from a non-comment token");
        }
    }

    protected String commentText() {
        return Tokens.getCommentText(super.token);
    }
}
