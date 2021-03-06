/*
 * Licensed to STRATIO (C) under one or more contributor license agreements.
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.  The STRATIO (C) licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.stratio.meta.sh.utils;

import static jline.internal.Preconditions.checkNotNull;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import com.stratio.meta.common.utils.MetaUtils;

import jline.console.completer.Completer;

public class MetaCompletor implements Completer {

    /**
     * Set containing the words used in the Meta Completor.
     */
    private final SortedSet<String> strings = new TreeSet<>();

    /**
     * Constructor of the Meta Completor for the Meta Console.
     */
    public MetaCompletor() {
    }

    @Override
    public int complete(final String buffer, final int cursor, final List<CharSequence> candidates) {
        checkNotNull(candidates);
        if ((buffer == null) || (buffer.length() < 1)) {
            candidates.addAll(MetaUtils.INITIALS);
        } else {
            // Last char is a space ==> NO completion implemented yet
            if (buffer.charAt(buffer.length() - 1) == ' ') {
                return -1;
            }
            strings.clear();
            String[] partialTokens = buffer.split(" ");
            String partialQuery = buffer.trim().toUpperCase();
            if (partialTokens.length == 1) {
                // First token
                strings.addAll(MetaUtils.INITIALS);
            } else {
                // NO first token and new token initiated
                strings.addAll(MetaUtils.NON_INITIALS);
                partialQuery = partialTokens[partialTokens.length - 1].trim().toUpperCase();
            }

            for (String match : strings.tailSet(partialQuery)) {
                if (!match.startsWith(partialQuery)) {
                    break;
                }
                candidates.add(match);
            }

        }
        if (candidates.size() == 1) {
            candidates.set(0, candidates.get(0) + " ");
        }
        return candidates.isEmpty() ? -1 : 0;
    }

}
