package com.hackaton.endava.calendar;

import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.ar.core.AugmentedImage;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ViewRenderable;

import java.util.concurrent.CompletableFuture;

public class AugmentedImageNode extends AnchorNode {

    private static final String TAG = "AugmentedImageNode";

    // The augmented image represented by this node.
    private AugmentedImage image;

    private static CompletableFuture<ViewRenderable> calendarView;


    public AugmentedImageNode(Context context) {
        // Upon construction, start loading the models for the corners of the frame.

        if (calendarView == null) {
            calendarView = ViewRenderable.builder().setView(context, R.layout.calendar_view).build();
        }

    }

    /**
     * Called when the AugmentedImage is detected and should be rendered. A Sceneform node tree is
     * created based on an Anchor created from the image. The corners are then positioned based on the
     * extents of the image. There is no need to worry about world coordinates since everything is
     * relative to the center of the image, which is the parent node of the corners.
     */
    @SuppressWarnings({"AndroidApiChecker", "FutureReturnValueIgnored"})
    public void setImage(AugmentedImage image) {
        this.image = image;

        // If any of the models are not loaded, then recurse when all are loaded.
        if (!calendarView.isDone()) {
            CompletableFuture.allOf(calendarView)
                    .thenAccept((Void aVoid) -> setImage(image))
                    .exceptionally(
                            throwable -> {
                                Log.e(TAG, "Exception loading", throwable);
                                return null;
                            });
        }

        ViewRenderable now = calendarView.getNow(null);
        if (now != null) {
            LinearLayout layout = (LinearLayout) now.getView();
            TextView tittle = layout.findViewById(R.id.tittle);
            tittle.setText(image.getName());
        }

        // Set the anchor based on the center of the image.
        setAnchor(image.createAnchor(image.getCenterPose()));

        // Make the 4 corner nodes.
        Vector3 localPosition = new Vector3();
        localPosition.set(0.0f , 0.0f, 0.0f);

        Node viewNode = new Node();
        viewNode.setParent(this);
        viewNode.setLocalPosition(localPosition);
        viewNode.setRenderable(now);
    }

    public AugmentedImage getImage() {
        return image;
    }
}