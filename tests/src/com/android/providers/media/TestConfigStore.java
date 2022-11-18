/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.providers.media;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * {@link ConfigStore} implementation that does not attempt to read the "real" configs (usually
 * stored to {@link android.provider.DeviceConfig}) and instead simply returns default values.
 */
public class TestConfigStore implements ConfigStore {
    private @Nullable List<String> mAllowedCloudProviders = null;
    private int mPickerSyncDelayMs = 0;

    @Override
    public @NonNull List<String> getAllowlistedCloudProviders() {
        return mAllowedCloudProviders != null ? mAllowedCloudProviders : Collections.emptyList();
    }

    public void setAllowedCloudProviders(String... providers) {
        mAllowedCloudProviders = Arrays.asList(providers);
    }

    public void clearAllowedCloudProviders() {
        mAllowedCloudProviders = null;
    }

    @Override
    public int getPickerSyncDelayMs() {
        return mPickerSyncDelayMs;
    }

    public void setPickerSyncDelayMs(int delay) {
        mPickerSyncDelayMs = delay;
    }

    @NonNull
    @Override
    public List<String> getTranscodeCompatManifest() {
        return Collections.emptyList();
    }

    @NonNull
    @Override
    public List<String> getTranscodeCompatStale() {
        return Collections.emptyList();
    }

    @Override
    public void addOnChangeListener(@NonNull Executor executor, @NonNull Runnable listener) {
        // No-op.
    }
}