/*
 * (C) Copyright 2006-2011 Nuxeo SA (http://nuxeo.com/) and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     Thomas Roger <troger@nuxeo.com>
 */

package org.nuxeo.ecm.social.mini.message;

import java.io.Serializable;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.nuxeo.ecm.activity.ActivitiesList;
import org.nuxeo.ecm.activity.Activity;
import org.nuxeo.ecm.social.relationship.RelationshipKind;

/**
 * Service handling mini messages.
 *
 * @author <a href="mailto:troger@nuxeo.com">Thomas Roger</a>
 * @since 5.5
 */
public interface MiniMessageService {

    /**
     * Add a new mini message.
     *
     * @return the newly created MiniMessage object.
     */
    MiniMessage addMiniMessage(Principal principal, String message,
            Date publishedDate);

    /**
     * Add a new mini message for the given {@code context}.
     *
     * @return the newly created MiniMessage object.
     */
    MiniMessage addMiniMessage(Principal principal, String message,
            Date publishedDate, String contextActivityObject);

    /**
     * Add a new mini message.
     *
     * @return the newly created MiniMessage object.
     */
    MiniMessage addMiniMessage(Principal principal, String message);

    /**
     * Remove a mini message.
     */
    void removeMiniMessage(MiniMessage miniMessage);

    /**
     * Returns the mini message for the given {@code miniMessageId}, or
     * {@code null} if no mini message exists with the given
     * {@code miniMessageId}.
     *
     * @since 5.6
     */
    MiniMessage getMiniMessage(Serializable miniMessageId);

    /**
     * Returns the mini messages for the given {@code actorActivityObject}. The
     * {@code relationshipKind} is used to find people with whom the actor has a
     * relation.
     *
     * @param offset the offset (starting at 0) into the list of mini messages.
     * @param limit the maximum number of mini messages to retrieve, or 0 for
     *            all of them.
     */
    List<MiniMessage> getMiniMessageFor(String actorActivityObject,
            RelationshipKind relationshipKind, long offset, long limit);

    /**
     * Returns the mini messages for the given {@code actorActivityObject} and
     * {@code contextActivityObject}. The {@code relationshipKind} is used to
     * find people with whom the actor has a relation.
     *
     * @param offset the offset (starting at 0) into the list of mini messages.
     * @param limit the maximum number of mini messages to retrieve, or 0 for
     *            all of them.
     */
    List<MiniMessage> getMiniMessageFor(String actorActivityObject,
            RelationshipKind relationshipKind, String contextActivityObject,
            long offset, long limit);

    /**
     * Returns the mini messages from the given {@code actorActivityObject}.
     *
     * @param offset the offset (starting at 0) into the list of mini messages.
     * @param limit the maximum number of mini messages to retrieve, or 0 for
     *            all of them.
     */
    List<MiniMessage> getMiniMessageFrom(String actorActivityObject,
            long offset, long limit);

    /**
     * Returns the mini messages, as a list of {@link Activity}, for the given
     * {@code actorActivityObject}. The {@code relationshipKind} is used to find
     * people with whom the actor has a relation.
     *
     * @param offset the offset (starting at 0) into the list of mini messages.
     * @param limit the maximum number of mini messages to retrieve, or 0 for
     *            all of them.
     * @since 5.6
     */
    ActivitiesList getMiniMessageActivitiesFor(String actorActivityObject,
            RelationshipKind relationshipKind, long offset, long limit);

    /**
     * Returns the mini messages, as a list of {@link Activity}, for the given
     * {@code actorActivityObject} and {@code contextActivityObject}. The
     * {@code relationshipKind} is used to find people with whom the actor has a
     * relation.
     *
     * @param offset the offset (starting at 0) into the list of mini messages.
     * @param limit the maximum number of mini messages to retrieve, or 0 for
     *            all of them.
     * @since 5.6
     */
    ActivitiesList getMiniMessageActivitiesFor(String actorActivityObject,
            RelationshipKind relationshipKind, String contextActivityObject,
            long offset, long limit);

    /**
     * Returns the mini messages, as a list of {@link Activity}, from the given
     * {@code actorActivityObject}.
     *
     * @param offset the offset (starting at 0) into the list of mini messages.
     * @param limit the maximum number of mini messages to retrieve, or 0 for
     *            all of them.
     * @since 5.6
     */
    ActivitiesList getMiniMessageActivitiesFrom(String actorActivityObject,
            long offset, long limit);

}
