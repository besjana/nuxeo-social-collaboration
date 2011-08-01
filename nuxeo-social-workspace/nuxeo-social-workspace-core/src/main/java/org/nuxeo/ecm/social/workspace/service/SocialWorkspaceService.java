/*
 * (C) Copyright 2006-2011 Nuxeo SA (http://nuxeo.com/) and contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  Contributors:
 *      Nuxeo
 */

package org.nuxeo.ecm.social.workspace.service;

import java.security.Principal;
import java.util.List;

import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.DocumentRef;
import org.nuxeo.ecm.social.workspace.adapters.SocialWorkspace;
import org.nuxeo.ecm.social.workspace.adapters.SubscriptionRequest;

/**
 * Service interface for Social Workspace.
 */
public interface SocialWorkspaceService {

    /**
     * Handles a Social Workspace creation:
     * <ul>
     * <li>create related groups</li>
     * <li>put specific ACLs</li>
     * </ul>
     *
     * @param principal the Principal initializing the Social Workspace
     */
    void handleSocialWorkspaceCreation(SocialWorkspace socialWorkspace,
            Principal principal);

    /**
     * Handles a Social Workspace deletion:
     * <ul>
     * <li>remove related groups</li>
     * </ul>
     */
    void handleSocialWorkspaceDeletion(SocialWorkspace socialWorkspace);

    /**
     * Returns the {@code SocialWorkspace} container of the given document if it
     * is in a Social Workspace even if the user does not have right on it,
     * {@code null} otherwise.
     * <p>
     * The underlying {@code DocumentModel} is detached.
     */
    SocialWorkspace getDetachedSocialWorkspaceContainer(DocumentModel doc);

    /**
     * Returns the {@code SocialWorkspace} container of the given document ref
     * if it is in a Social Workspace even if the user does not have right on
     * it, {@code null} otherwise.
     * <p>
     * The underlying {@code DocumentModel} is detached.
     */
    SocialWorkspace getDetachedSocialWorkspaceContainer(CoreSession session,
            DocumentRef docRef);

    /**
     * Returns the {@code SocialWorkspace} container of the given document if it
     * is part of a Social Workspace, {@code null} otherwise.
     */
    SocialWorkspace getSocialWorkspaceContainer(DocumentModel doc);

    /**
     * Adds a user to the @{code socialWorkspace} administrators group.
     *
     * @return {@code true} if the user was successfully added to the
     *         administrators group, {@code false} otherwise.
     */
    boolean addSocialWorkspaceAdministrator(SocialWorkspace socialWorkspace,
            String principalName);

    /**
     * Adds a user to the @{code socialWorkspace} members group.
     *
     * @return {@code true} if the user was successfully added to the members
     *         group, {@code false} otherwise.
     */
    boolean addSocialWorkspaceMember(SocialWorkspace socialWorkspace,
            String principalName);

    /**
     * Removes a user from the @{code socialWorkspace} administrators group.
     */
    void removeSocialWorkspaceAdministrator(SocialWorkspace socialWorkspace,
            String principalName);

    /**
     * Removes a user from the @{code socialWorkspace} members group.
     */
    void removeSocialWorkspaceMember(SocialWorkspace socialWorkspace,
            String principalName);

    /**
     * Makes the given {@code socialWorkspace} public.
     * <p>
     * Puts the correct rights so that non-members can view public documents and
     * publci dashboard.
     */
    void makeSocialWorkspacePublic(SocialWorkspace socialWorkspace);

    /**
     * Makes the given {@code socialWorkspace} private.
     * <p>
     * Restricts rights for non-members users.
     */
    void makeSocialWorkspacePrivate(SocialWorkspace socialWorkspace);

    /**
     * Gets the number of days before a social workspace expires without
     * validation.
     *
     * @return number of days
     */
    int getValidationDays();

    /**
     * Handles a Subscription Request on {@code socialWorkspace} for the given
     * {@code principalName}.
     */
    void handleSubscriptionRequest(SocialWorkspace socialWorkspace,
            String principalName);

    /**
     * Returns {@code true} if there is a pending Subscription Request for the
     * given {@code principalName}, {@code false} otherwise.
     */
    boolean isSubscriptionRequestPending(SocialWorkspace socialWorkspace,
            String principalName);

    /**
     * Accepts the {@code subscriptionRequest} for {@code socialWorkspace}.
     */
    void acceptSubscriptionRequest(SocialWorkspace socialWorkspace,
            SubscriptionRequest subscriptionRequest);

    /**
     * Rejects the {@code subscriptionRequest} for {@code socialWorkspace}.
     */
    void rejectSubscriptionRequest(SocialWorkspace socialWorkspace,
            SubscriptionRequest subscriptionRequest);

    /**
     * Return matching public social workspace according the given pattern.
     */
    List<SocialWorkspace> searchDetachedPublicSocialWorkspaces(
            CoreSession session, String pattern);

    /**
     * Return all public Social Workspaces.
     */
    List<SocialWorkspace> getDetachedPublicSocialWorkspaces(CoreSession session);

}
