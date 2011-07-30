package org.nuxeo.ecm.social.workspace.adapters;

import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.NuxeoPrincipal;

/**
 * An object that wraps a {@code DocumentModel} having the facet
 * {@code SocialWorkspace}.
 *
 * @author <a href="mailto:troger@nuxeo.com">Thomas Roger</a>
 * @since 5.4.3
 */
public interface SocialWorkspace {

    /**
     * Returns the title of this Social Workspace.
     */
    String getTitle();

    /**
     * Returns the full path of this Social Workspace.
     */
    String getPath();

    /**
     * Returns {@code true} if this Social Workspace is public, {@code false}
     * otherwise.
     */
    boolean isPublic();

    /**
     * Returns {@code true} if this Social Workspace is private, {@code false}
     * otherwise.
     */
    boolean isPrivate();

    /**
     * Make this Social Workspace public.
     */
    void makePublic();

    /**
     * Make this Social Workspace private.
     */
    void makePrivate();

    /**
     * Returns {@code true} if the subscriptions to this Social Workspace need
     * an administrator approval, {@code false} otherwise.
     */
    boolean mustApproveSubscription();

    /**
     * Adds a user to this Social Workspace administrators group.
     */
    void addAdministrator(String principalName);

    /**
     * Adds a user to this Social Workspace members group.
     */
    void addMember(String principalName);

    /**
     * Removes a user from this Social Workspace administrators group.
     */
    void removeAdministrator(String principalName);

    /**
     * Removes a user from this Social Workspace members group.
     */
    void removeMember(String principalName);

    /**
     * Returns true if the given {@code principal} is administrator of this
     * Social Workspace, {@code false} otherwise.
     */
    boolean isAdministrator(NuxeoPrincipal principal);

    /**
     * Returns true if the given {@code principal} is member of this Social
     * Workspace, {@code false} otherwise.
     */
    boolean isMember(NuxeoPrincipal principal);

    /**
     * Returns true if the given {@code principal} is administrator or member of
     * this Social Workspace, {@code false} otherwise.
     */
    boolean isAdministratorOrMember(NuxeoPrincipal principal);

    /**
     * Returns this Social Workspace administrators group name.
     */
    String getAdministratorsGroupName();

    /**
     * Returns this Social Workspace administrators group label.
     */
    String getAdministratorsGroupLabel();

    /**
     * Returns this Social Workspace members group name.
     */
    String getMembersGroupName();

    /**
     * Returns this Social Workspace members group label.
     */
    String getMembersGroupLabel();

    /**
     * Returns the path of the public Section of this Social Workspace.
     */
    String getPublicSectionPath();

    /**
     * Returns the path of the private Section of this Social Workspace.
     */
    String getPrivateSectionPath();

    /**
     * Returns the path of the News Items root of this Social Workspace.
     */
    String getNewsItemsRootPath();

    /**
     * Returns the path of the Dashboard spaces root of this Social Workspace.
     */
    String getDashboardSpacesRootPath();

    /**
     * Returns the path of the public Dashboard Space of this Social Workspace.
     */
    String getPublicDashboardSpacePath();

    /**
     * Returns the path of the private Dashboard Space of this Social Workspace.
     */
    String getPrivateDashboardSpacePath();

    /**
     * Returns the underlying {@DocumentModel}.
     */
    DocumentModel getDocument();

    /**
     * Sets the underlying {@DocumentModel}.
     * <p>
     * Must be the same document (same id), otherwise throw a RuntimeException.
     */
    void setDocument(DocumentModel doc);

}