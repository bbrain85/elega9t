/*
 * Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 * ELEGA9T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.Copyright (c) 2011 - 2012. Elega9t Ltd. All rights reserved.
 */

package com.elega9t.intellij.plugin.jbehave.actions;

import com.intellij.CommonBundle;
import com.intellij.ide.actions.CreateElementActionBase;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class CreateNewFeatureFileAction extends CreateElementActionBase {

    private final String FEATURE_FILE_SUFFIX = ".feature";

    protected CreateNewFeatureFileAction() {
        super("jBehave Feature File", "Create a new jBehave feature file", new ImageIcon(CreateNewFeatureFileAction.class.getResource("/com/elega9t/intellij/plugin/jbehave/feature.png")));
    }

    @NotNull
    @Override
    protected PsiElement[] invokeDialog(Project project, PsiDirectory directory) {
        MyInputValidator validator = new MyInputValidator(project, directory);
        Messages.showInputDialog (project, "File name:", "jBehave Feature File", Messages.getQuestionIcon(), "", validator);
        return validator.getCreatedElements();
    }

    @NotNull
    @Override
    protected PsiElement[] create(String name, PsiDirectory directory) throws Exception {
        if(!name.endsWith(FEATURE_FILE_SUFFIX)) {
            name = name + FEATURE_FILE_SUFFIX;
        }
        return new PsiElement[] {PsiFileFactory.getInstance(directory.getProject()).createFileFromText(name, "Hi There")};
    }

    @Override
    protected String getErrorTitle() {
        return CommonBundle.getErrorTitle();
    }

    @Override
    protected String getCommandName() {
        return "jBehave Feature File";
    }

    @Override
    protected String getActionName(PsiDirectory directory, String s) {
        return "jBehave Feature File";
    }

}
