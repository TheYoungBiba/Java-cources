package edu.hw11.task3;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;

@SuppressWarnings({"MultipleStringLiterals", "MagicNumber"})
class FibonacciBCAppender implements ByteCodeAppender {
    @Override
    public Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methDescription) {
        methodVisitor.visitCode();
        Label lessOrEquals0 = new Label();
        Label equals0 = new Label();
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 0);
        methodVisitor.visitJumpInsn(Opcodes.IFLE, lessOrEquals0);
        methodVisitor.visitInsn(Opcodes.ICONST_1);
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 0);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPEQ, equals0);
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 0);
        methodVisitor.visitInsn(Opcodes.ICONST_2);
        methodVisitor.visitInsn(Opcodes.ISUB);
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "Fibonacci",
            "fib",
            "(I)J",
            false);
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 0);
        methodVisitor.visitInsn(Opcodes.ICONST_1);
        methodVisitor.visitInsn(Opcodes.ISUB);
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKESTATIC,
            "Fibonacci",
            "fib",
            "(I)J",
            false
        );
        methodVisitor.visitInsn(Opcodes.LADD);
        methodVisitor.visitInsn(Opcodes.LRETURN);
        methodVisitor.visitLabel(lessOrEquals0);
        methodVisitor.visitFrame(
            Opcodes.F_SAME,
            0,
            null,
            0,
            null
        );
        methodVisitor.visitInsn(Opcodes.LCONST_0);
        methodVisitor.visitInsn(Opcodes.LRETURN);
        methodVisitor.visitLabel(equals0);
        methodVisitor.visitFrame(
            Opcodes.F_SAME,
            0,
            null,
            0,
            null
        );
        methodVisitor.visitInsn(Opcodes.LCONST_1);
        methodVisitor.visitInsn(Opcodes.LRETURN);
        methodVisitor.visitMaxs(4, 1);
        methodVisitor.visitEnd();
        return new Size(4, 1);
    }
}
